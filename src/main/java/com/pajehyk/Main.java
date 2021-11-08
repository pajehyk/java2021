package com.pajehyk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import com.pajehyk.multithread.MyThread;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Scanner scanner = new Scanner(new File("src/main/resources/inputFile.txt"));
        PrintStream printStream = new PrintStream(new File("src/main/resources/outputFile.txt"));
        printStream = System.out;
        MyThread myThread1 = MyThread.createAndStartThread(scanner, printStream, "Thread 1");
        MyThread myThread2 = MyThread.createAndStartThread(scanner, printStream, "Thread 2");
    }
}
