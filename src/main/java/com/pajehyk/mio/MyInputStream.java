package com.pajehyk.mio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class MyInputStream extends FileInputStream{
    public MyInputStream(File file) throws FileNotFoundException {
        super(file);
    }

    public synchronized Integer readInt() throws IOException, InterruptedException {
        char[] bytes = new char[32];
        Integer number = null;
        int length = 0;
        while (true) {
            int character = this.read();
            //System.out.println(character);
            if (character == 32 || character == -1) {
                if (length != 0) {
                    String numberString = String.valueOf(Arrays.copyOf(bytes, length));
                    number = Integer.parseInt(numberString);
                    break;
                } else {
                    if (character == -1) {
                        break;
                    }
                }
            } else {
                bytes[length] = (char)character;
                length++;
            }
        }
        return number;
    }
    public int testingRead() throws IOException {
        return this.read();
    }
}
