package com.pajehyk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        final long startTime = System.currentTimeMillis();
        String inputFilePath = "src/test/resources/input10000.txt";
        String expectedOutputFilePath = "src/test/resources/expectedOutput10000.txt";
        Scanner scan = new Scanner(new File(inputFilePath));
        PrintStream ps = new PrintStream(new File(expectedOutputFilePath));
        for (int i = 0; i < 10000; i++) {
            ps.println(Math.tan(scan.nextDouble()));
        }
        final long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime));
    }   
}
