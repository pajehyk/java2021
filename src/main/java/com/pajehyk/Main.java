package com.pajehyk;

import java.io.IOException;

import com.pajehyk.streamapi.StreamAPI;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamAPI.countToFile("src/main/resources/pin.txt", "src/main/resources/counts.txt");
        StreamAPI.writeToFiles("src/main/resources/pin.txt", "/users/pajehyk/directory");
    }   
}
