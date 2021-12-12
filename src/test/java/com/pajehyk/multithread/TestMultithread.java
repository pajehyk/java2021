package com.pajehyk.multithread;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

public class TestMultithread {
    private String inputFilePath = "src/test/resources/input10000.txt";
    private String actualOutputFilePath = "src/test/resources/actualOutput10000.txt";
    private String expectedOutputFilePath = "src/test/resources/expectedOutput10000.txt";
    Multithread mt = new Multithread(inputFilePath, actualOutputFilePath);

    @Test
    public void testStart() throws IOException, InterruptedException, ExecutionException {
        mt.compute(2);
        assertEquals(FileUtils.readFileToString(new File(actualOutputFilePath), "utf-8"),
            FileUtils.readFileToString(new File(expectedOutputFilePath), "utf-8"));
    }
}
