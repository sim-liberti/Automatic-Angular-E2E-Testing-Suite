package org.unina;

import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.unina.data.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestRunnerEngine {

    private static final int NPM_START_TIMEOUT_SEC = 120;
    private static final int REBUILD_TIMEOUT_SEC = 20;

    public static void runTests(Config config, MutationDatabase db, File testsRootFolder) throws Exception {
        ClassLoader externalLoader = createClassLoader(testsRootFolder);
        List<Class<?>> testClasses = loadTestClasses(testsRootFolder, externalLoader);

        System.out.println("Found " + testClasses.size() + " classes to execute.");

        Set<Mutation> mutations = db.getPendingMutations();
        System.out.println("Found " + mutations.size() + " mutations to apply.");

        NpmConsoleWrapper npm = new NpmConsoleWrapper(false);
        if (!startTargetApplication(npm, config)) {
            return;
        }

        List<MutationBatch> history = new ArrayList<>();
        int remaining = mutations.size();

        Thread.currentThread().setContextClassLoader(externalLoader);

        Instant start = Instant.now();
        try {
            for (Mutation mutation : mutations) {
                db.updateMutation(mutation.mutation_id, "RUNNING");
                System.out.printf("\n%d out of %d remaining.\n", remaining--, (long) mutations.size());
                history.add(processMutation(mutation, npm, db, testClasses));
                db.updateMutation(mutation.mutation_id, "COMPLETE");
            }
        } finally {
            npm.stop();
            saveResults(history);
            Instant end = Instant.now();
            long timeElapsed = Duration.between(start, end).toSeconds();
            System.out.println("\nTests completed.");
            System.out.println("Execution time: " + timeElapsed + " seconds.");
        }
    }

    private static boolean startTargetApplication(NpmConsoleWrapper npm, Config config) throws IOException {
        System.out.println("Starting TypeScript application (npm start)...");
        npm.start(config.repositoryRootPath, config.npmRunCommand);

        if (!npm.waitForRebuild(NPM_START_TIMEOUT_SEC)) {
            System.err.println("Failed to start TypeScript application within timeout.");
            npm.stop();
            return false;
        }
        System.out.println("TypeScript application started.");
        return true;
    }

    private static MutationBatch processMutation(Mutation mutation, NpmConsoleWrapper npm, MutationDatabase db, List<Class<?>> testClasses) throws IOException {
        MutationBatch batch = new MutationBatch();
        batch.batchName = mutation.name;
        batch.batchId = String.format("mutation_%s_%s_%s", mutation.mutation_id, mutation.mutation_type, mutation.element);

        mutation.mutatedFiles = db.getMutatedFiles(mutation.uuid);
        mutation.applyMutationToRepository();
        npm.resetForNextBuild();

        System.out.println("Mutation " + batch.batchId + " applied. Waiting for recompile...");

        boolean recompiled = npm.waitForRebuild(REBUILD_TIMEOUT_SEC);
        if (recompiled) System.out.println("Application recompiled successfully.");
        else System.out.println("Application did not recompile.");

        try {
            for (Class<?> cls : testClasses) {
                if (!recompiled) {
                    System.out.println("Skipping test " + cls.getSimpleName() + ": " + "Application did not recompile.");
                    System.out.println("---------------------------------------------");
                    batch.addExecution(new TestExecution(
                        mutation.name,
                        cls.getSimpleName(),
                        mutation.element,
                        TestStatus.NOT_APPLICABLE,
                        "Application did not recompile."
                    ));
                    continue;
                }

                batch.addExecution(executeTest(mutation, cls));
            }
        } finally {
            mutation.revertMutations();
        }

        return batch;
    }

    private static TestExecution executeTest(Mutation mutation, Class<?> cls) {
        System.out.println("Starting test for: " + cls.getSimpleName());

        Logger.getLogger("org.junit").setLevel(Level.OFF);

        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(DiscoverySelectors.selectClass(cls))
                .build();

        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        Launcher launcher = LauncherFactory.create();
        launcher.registerTestExecutionListeners(listener);

        try {
            launcher.execute(request);
        } catch (Exception e) {
            return new TestExecution(mutation.name, cls.getSimpleName(), mutation.element, TestStatus.BROKEN, "Launcher Error: " + e.getMessage());
        }

        TestExecutionResult result = analyzeResult(listener.getSummary());

        System.out.println("Test ended: " + cls.getSimpleName() + " [" + result.status + "] " + result.errorMessage);
        System.out.println("---------------------------------------------");

        TestExecution execution = new TestExecution(mutation.name, cls.getSimpleName(), mutation.element);
        execution.status = result.status;
        execution.errorMessage = result.errorMessage;
        return execution;
    }

    // Utility methods

    private static ClassLoader createClassLoader(File rootFolder) throws Exception {
        URL[] urls = new URL[]{rootFolder.toURI().toURL()};
        return new URLClassLoader(urls, Thread.currentThread().getContextClassLoader());
    }

    private static List<Class<?>> loadTestClasses(File rootFolder, ClassLoader loader) {
        List<Class<?>> classes = new ArrayList<>();
        scanFolder(rootFolder, rootFolder, loader, classes);
        return classes;
    }

    private static void scanFolder(File currentFolder, File rootFolder, ClassLoader loader, List<Class<?>> classes) {
        File[] files = currentFolder.listFiles();

        if (files == null) {
            System.err.println("Cannot read folder: " + currentFolder.getAbsolutePath());
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                scanFolder(file, rootFolder, loader, classes);
            } else if (file.getName().endsWith(".class")) {
                try {
                    String absoluteFilePath = file.getAbsolutePath();
                    String absoluteRootPath = rootFolder.getAbsolutePath();
                    String relativePath = absoluteFilePath.substring(absoluteRootPath.length() + 1);
                    String className = relativePath
                            .replace(File.separatorChar, '.')
                            .replace(".class", "");

                    Class<?> clazz = loader.loadClass(className);
                    if (java.lang.reflect.Modifier.isAbstract(clazz.getModifiers()))
                        System.out.println("Loaded abstract class: " + clazz.getSimpleName());
                    else if (clazz.getSimpleName().contains("Factory"))
                        System.out.println("Loaded factory class: " + clazz.getSimpleName());
                    else {
                        classes.add(clazz);
                        System.out.println("Loaded class: " + clazz.getSimpleName());
                    }
                } catch (Exception e) {
                    System.err.println("Error while reading file: " + file.getName());
                }
            }
        }
    }

    private static TestExecutionResult analyzeResult(TestExecutionSummary summary) {
        if (summary.getTestsFailedCount() == 0) {
            return new TestExecutionResult(TestStatus.PASSED, null);
        }

        var failure = summary.getFailures().getFirst();
        Throwable ex = failure.getException();
        String msg = ex.getMessage() != null
                ? ex.getMessage().replace(",", " ")
                : ex.toString();
        String regex = "^(Build|System|Driver|Capabilities|Session ID| {2}\\(Session|For docu|Command|Element).*";
        msg = msg.replaceAll("(?m)" + regex, "");
        msg = msg.replaceAll("(?m)" + "\n", "");

        TestStatus status = (ex instanceof java.lang.AssertionError ||
                ex instanceof org.openqa.selenium.WebDriverException) // String check is safer for optional deps
                ? TestStatus.FAILED
                : TestStatus.BROKEN;

        return new TestExecutionResult(status, msg);
    }

    private static void saveResults(List<MutationBatch> batches) {
        Map<String, LocatorStats> statsMap = new HashMap<>();
        StringBuilder batchCsv = new StringBuilder();
        batchCsv.append("Name,Id,Locator,Tag,Status,Error\n");

        for (MutationBatch batch : batches) {
            BatchStatus status = batch.getBatchStatus();

            for (TestExecution exec : batch.getExecutions()) {
                batchCsv.append(String.format("%s,%s,%s,%s,%s,%s\n",
                        batch.batchName, batch.batchId, exec.locatorName, exec.mutatedTag, exec.status.toString(), exec.errorMessage));

                LocatorStats stats = statsMap.computeIfAbsent(
                        exec.locatorName,
                        LocatorStats::new
                );

                switch (status) {
                    case OBSOLETE:
                        stats.obsolescenceFailureCount++;
                        break;
                    case FRAGILE:
                        if (exec.isPassed())
                            stats.successCount++;
                        else
                            stats.fragilityFailureCount++;
                        break;
                    case ROBUST:
                        stats.successCount++;
                        break;
                    case NOT_TESTED:
                        stats.notTestedCount++;
                        break;
                }
            }
        }

        StringBuilder statsCsv = new StringBuilder();
        statsCsv.append("Locator,Total,Success,Fragility,Obsolescence,Not Compiled\n");
        for (LocatorStats stats : statsMap.values()) {
            statsCsv.append(stats.toString()).append("\n");
        }

        System.out.println("Executed batches:");
        System.out.println(batchCsv);
        System.out.println("\nTest results:");
        System.out.println(statsCsv);

        String outputDir = "output/tests/";

        try {
            Files.createDirectories(Paths.get(outputDir));
        } catch (IOException e) {
            System.err.println("Cannot create output directory: " + e.getLocalizedMessage());
        }

        saveCsv(batchCsv.toString(), Paths.get(outputDir + "batches.csv").toString());
        saveCsv(statsCsv.toString(), Paths.get(outputDir + "stats.csv").toString());
    }

    private static void saveCsv(String content, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, StandardCharsets.UTF_8))) {
            writer.write(content);
            System.out.println("File saved: " + path);

        } catch (IOException unused) {
            System.err.println("Error while saving " + path);
        }
    }

    private record TestExecutionResult(TestStatus status, String errorMessage) {}
}
