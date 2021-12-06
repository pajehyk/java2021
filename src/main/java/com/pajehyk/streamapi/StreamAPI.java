package com.pajehyk.streamapi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

public class StreamAPI {
    private static HashMap<String, Integer> hashMap;

    private static void countWords(String pathString) {
        Path path = Paths.get(pathString);
        try (Stream<String> streamFromLines = Files.lines(path, Charset.forName("UTF-8"))) {
            Stream<Stream<String>> streamFromStreamOfLines = streamFromLines.map(string -> Stream.of(string.split("\\. |, | |\\.")));
            Stream<String> streamFromWords = streamFromStreamOfLines.flatMap(x -> x);
            Stream<HashMap<String, Integer>> stream3 = streamFromWords.map(string -> {
                HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
                hm1.put(string, 1);
                return hm1;
            });
            hashMap = stream3.reduce((x, y) -> {
                y.forEach((key, value) -> x.merge(key, value, Integer::sum));
                return x;
            }).get();
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void countToFile(String inputPathString, String outputPathString) {
        try (PrintStream ps = new PrintStream(new File(outputPathString))) {
            countWords(inputPathString);
            for (HashMap.Entry<String, Integer> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                ps.println(key + " " + value);
            }
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void writeToFiles(String inputPathString, String outputDirectoryPathString) {
        List<CompletableFuture<Path>> list = new ArrayList<CompletableFuture<Path>>(); 
        for (String key: hashMap.keySet()) {
            list.add(CompletableFuture.supplyAsync(() -> {
                Path path = null;
                try {
                    path =  Files.createFile(Paths.get(outputDirectoryPathString + "/" + key));
                } catch(IOException exc) {
                    System.out.println(exc.getMessage());
                }
                return path;
            }));
        }
        try {
            for (CompletableFuture<Path> cf: list) {
                if (cf.get() != null) {
                    Path path = cf.get();
                    PrintStream ps = new PrintStream(path.toFile());
                    for (int i = 0; i < hashMap.get(path.getFileName().toString()); i++) {
                        ps.print(path.getFileName().toString() + " ");
                    }
                }
            }
        } catch(InterruptedException exc) {
            System.out.println(exc.getMessage());
        } catch(ExecutionException exc) {
            System.out.println(exc.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
