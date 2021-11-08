package com.pajehyk;

import java.io.File;
import java.io.FileNotFoundException;

import com.pajehyk.mio.MyInputStream;
import com.pajehyk.multithread.MyThread;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        MyInputStream fis = new MyInputStream(new File("src/main/resources/inputFile.txt"));
        MyThread myThreadGreen = MyThread.createAndStartThread(fis, "Thread 1");
        MyThread myThreadRed = MyThread.createAndStartThread(fis, "Thread 2");
    }
}
