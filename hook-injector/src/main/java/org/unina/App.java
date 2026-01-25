package org.unina;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    static final String[] args = new String[5];

    public static void main(String[] args){
//        args[0] = ".html";
//        args[1] = "angularjs";
//        args[2] = "/home/simon/Documents/Projects/angular-spotify";

        Path start = Paths.get(args[2]);
        String osName = System.getProperty("os.name").toLowerCase();
        String currentWorkingDir = System.getProperty("user.dir");
        String batchFileName = osName.contains("win") ? "hookInjection.bat" : "hookInjection.sh";
        Path batchFilePath = Paths.get(currentWorkingDir, batchFileName);

        System.out.println("Starting injection");
        try {
            Stream<Path> streamPath = Files.walk(start, Integer.MAX_VALUE);
            List<String> feFilePathList = streamPath
                    .map(String::valueOf)
                    .filter(path -> !path.contains(".nx") && !path.contains("node_modules"))
                    .filter(fileName -> fileName.contains(args[0]))
                    .sorted()
                    .collect(Collectors.toList());

            System.out.println("List of paths:");
            System.out.println(feFilePathList);
            List<String> commmandList = createHookInjectionContent(feFilePathList, args[1]);
            if (osName.contains("win")) {
                commmandList.add(0,"cd hook-injector\\test-hooks\\test-guard");
            } else {
                commmandList.add(0,"#!/bin/bash");
                commmandList.add(1,"cd hook-injector/test-hooks/test-guard");
            }
            System.out.println("List of commands to insert into hookInjection script:");
            System.out.println(commmandList);

            FileWriter myWriter = new FileWriter(batchFilePath.toFile());
            commmandList.forEach(feFile -> {
                try {
                    myWriter.write(feFile+"\n");
                } catch (IOException e) {
                    System.err.println("Error writing file: " + feFile + "\n");
                }
            });
            System.out.println("Successfully wrote to the file.");
            myWriter.close();

            try{
                ProcessBuilder pb = new ProcessBuilder();
                if (osName.contains("win")) {
                    pb.command("cmd.exe", "/c", batchFilePath.toString());
                } else {
                    pb.command("bash", batchFilePath.toString());
                }
                pb.redirectErrorStream(true);
                Process p = pb.start();
                int exitCode = p.waitFor();
                System.out.println("Script executed with exit code: " + exitCode);
            }catch(Exception e){
                System.err.println("Error : ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> createHookInjectionContent(List<String> fileFeList, String grammarType){
        List<String> commandList = new ArrayList<>();
        fileFeList.forEach(
                content -> {
                    content = "node main.js inject-hooks "
                            + "\"" + content + "\""
                            + " --grammar "
                            + grammarType;
                    commandList.add(content);
                }
        );
        return commandList;
    }

}
