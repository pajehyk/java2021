package com.pajehyk.streamapi;

import java.io.File;
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
        List<CompletableFuture<File>> list = new ArrayList<CompletableFuture<File>>(); 
        for (String key: hashMap.keySet()) {
            String stringPath = outputDirectoryPathString + "/" + key;
            list.add(CompletableFuture.supplyAsync(() -> {
                File file = new File(stringPath);
                try(PrintStream ps = new PrintStream(file)) {
                    Boolean bool = file.createNewFile();
                    for (int i = 0; i < hashMap.get(key); i++) {
                        ps.println(key);
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                return file;
            }));
        }
        CompletableFuture.allOf(list.toArray(new CompletableFuture<?>[0])).join();
    }
}
