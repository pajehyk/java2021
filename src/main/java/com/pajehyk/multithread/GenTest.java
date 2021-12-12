package com.pajehyk.multithread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class GenTest {
    public void generateAnswer(String inputFilePath, String expectedOutputFilePath, int n) 
        throws FileNotFoundException {
        //String inputFilePath = "src/test/resources/input10000.txt";
        //String expectedOutputFilePath = "src/test/resources/expectedOutput10000.txt";
        Scanner scan = new Scanner(new File(inputFilePath));
        PrintStream ps = new PrintStream(new File(expectedOutputFilePath));
        for (int i = 0; i < n; i++) {
            ps.println(Math.tan(scan.nextDouble()));
        }
    }
}
