package com.pajehyk.multithread;

import java.io.IOException;

import com.pajehyk.mio.MyInputStream;

public class MyThread implements Runnable {
    public Thread thread;
    private MyInputStream myInputStream;

    public MyThread(MyInputStream myInputStream, String name) {
        this.myInputStream = myInputStream;
        thread = new Thread(this, name);
    }

    public static MyThread createAndStartThread(MyInputStream myInputStream, String name) {
        MyThread myThread = new MyThread(myInputStream, name);
        myThread.thread.start();
        return myThread;
    }

    public void run() {
        try {
            int a = myInputStream.readInt();
            int b = myInputStream.readInt();
            System.out.println(a);
            System.out.println(b);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
