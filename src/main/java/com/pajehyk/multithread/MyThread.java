package com.pajehyk.multithread;

import java.io.PrintStream;
import java.util.Scanner;

public class MyThread implements Runnable {
    public Thread thread;
    private Scanner scanner;
    private PrintStream printStream;
    private static boolean running = true;

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
        while (running) {
            double a;
            double tan;
            synchronized(scanner) {
                if (scanner.hasNextDouble()) {
                    a = scanner.nextDouble();
                } else {
                    running = false;
                    break;
                }
            }
            tan = Math.tan(a);
            synchronized(scanner) {
                printStream.println(tan + Thread.currentThread().getName());
            }
        }
    }
}
