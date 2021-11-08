package com.pajehyk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import com.pajehyk.multithread.Compute;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Scanner scanner = new Scanner(new File("src/test/resources/input1000000.txt"));
        PrintStream printStream = new PrintStream(new File("src/main/resources/outputFile.txt"));
        Compute compute = new Compute();
        compute.ComputeWithThreads(scanner, printStream, 4);
    }
}
