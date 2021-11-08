package com.pajehyk.multithread;

import java.io.PrintStream;
import java.util.Scanner;

public class MyThread implements Runnable {
    public Thread thread;
    private Scanner scanner;
    private PrintStream printStream;

    public MyThread(Scanner scanner, PrintStream printStream, String name) {
        this.scanner = scanner;
        this.printStream = printStream;
        thread = new Thread(this, name);
    }

    public static MyThread createAndStartThread(Scanner scanner, PrintStream printStream, String name) {
        MyThread myThread = new MyThread(scanner, printStream, name);
        myThread.thread.start();
        return myThread;
    }

    public void run() {
        double[] array = new double[5];
        double[] tans = new double[5];
        synchronized(scanner) {
            for (int i = 0; i < 5; i++) {
                array[i] = scanner.nextDouble();
            }
        }
        for (int i = 0; i < 5; i++) {
            tans[i] = Math.tan(array[i]);
        }
        synchronized(printStream) {
            for (int i = 0; i < 5; i++) {
                printStream.print(tans[i] + " ");
            }
        }
    }
}
