package com.pajehyk.multithread;

import java.io.PrintStream;
import java.util.Scanner;

public class Compute {
    public void ComputeWithThreads(Scanner scanner, PrintStream printStream, int numberOfThreads) {
        MyThread[] myThreads = new MyThread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            myThreads[i] = MyThread.createAndStartThread(scanner, printStream, "Thread " + String.valueOf(i));
        }
        for (int i = 0; i < numberOfThreads; i++) {
            try {
                myThreads[i].thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
