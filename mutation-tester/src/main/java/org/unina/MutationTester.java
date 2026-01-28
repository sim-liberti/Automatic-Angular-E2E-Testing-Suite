package org.unina;

import org.unina.data.Config;
import org.unina.data.MutationDatabase;
import org.unina.util.ComponentIndexer;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "mutation-tester", mixinStandardHelpOptions = true,
                     description = "Application to automatically run junit tests with selenium webdriver.")
public class MutationTester implements Callable<Integer> {

    @CommandLine.Option(names = {"-c", "--config"}, description = "The path to the configuration file. Defaults to the current directory.")
    private final File configuration = new File("generator-config.json");

    @CommandLine.Option(names = {"-td", "--test-dir"}, required = true, description = "The path to the test directory.")
    private File testDirectory;

    @Override
    public Integer call() throws Exception {
        Path jsonPath = configuration.toPath();
        if (!Files.exists(jsonPath)) {
            System.err.println("Configuration file not found: " + jsonPath.toAbsolutePath());
            return 1;
        }
        if (!testDirectory.exists() || !testDirectory.isDirectory()) {
            System.err.println("Invalid test directory: " + testDirectory.getAbsolutePath());
            return 1;
        }
        Config jsonConfig = Config.loadConfiguration(jsonPath);
        if (jsonConfig == null) {
            System.err.println("Error initializing configuration object from " + jsonPath);
            return 1;
        }

        MutationDatabase db = new MutationDatabase();
        ComponentIndexer.initialize();

        try {
            ComponentIndexer.getInstance().buildSelectorMap(Paths.get(jsonConfig.repositoryRootPath));
        } catch (IOException e) {
            System.err.println("Error initializing Component Indexer: " + e.getMessage());
            return 1;
        }

        try {
            TestRunnerEngine.runTests(jsonConfig, db, testDirectory);
        } catch (Exception e) {
            System.err.println("Execution error: " + e.getMessage());
            return 1;
        }

        return 0;
    }

    public static void main(String[] unused) {
        String[] args = {
            "--test-dir", "/home/simon/Documents/Projects/Automatic-Angular-E2E-Testing-Suite/ext-test-classes/target/classes/"
        };
        int exitCode = new CommandLine(new MutationTester()).execute(args);
        System.exit(exitCode);
    }
}
