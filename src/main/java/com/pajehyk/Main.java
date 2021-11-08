package com.pajehyk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import com.pajehyk.multithread.Compute;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Scanner scanner = new Scanner(new File("src/main/resources/inputFile.txt"));
        PrintStream printStream = new PrintStream(new File("src/main/resources/outputFile.txt"));
        Compute compute = new Compute();
        compute.ComputeWithThreads(scanner, printStream, 2);
        System.out.println(Math.tan(0.6084669908981728));
    }
}
