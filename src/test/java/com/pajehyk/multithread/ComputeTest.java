package com.pajehyk.multithread;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import org.apache.commons.io.FileUtils;

import org.junit.jupiter.api.Test;

public class ComputeTest {
    @Test
    public void computeTest() throws FileNotFoundException, IOException {
        Compute compute = new Compute();
        File inputFile = new File("/Users/pajehyk/Documents/projects/java2021/src/test/resources/input10000.txt");
        File outputFile = new File("/Users/pajehyk/Documents/projects/java2021/src/test/resources/actualOutput10000.txt");
        File expectedFile = new File("/Users/pajehyk/Documents/projects/java2021/src/test/resources/expectedOutput10000.txt");
        Scanner scanner = new Scanner(inputFile);
        PrintStream printStream = new PrintStream(outputFile);
        compute.ComputeWithThreads(scanner, printStream, 2);
        assertEquals(FileUtils.readFileToString(expectedFile, "utf-8"), 
                    FileUtils.readFileToString(outputFile, "utf-8"));
    }
}
