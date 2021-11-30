package com.pajehyk.files;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

public class FilesTest {
    @Test 
    public void runTest() {
        String expectedFilePath = "src/test/resources/expectedOutput.txt";
        String actualFilePath = "src/test/resources/actualOutput.txt";
        String[] args = {"src/test/resources/predefined-file-structure", "src/test/resources/actualOutput.txt"};
        try {
            Files.run(args);
            File expectedFile = new File(expectedFilePath);
            File actualFile = new File(actualFilePath);
            assertEquals(FileUtils.readFileToString(expectedFile, "utf-8"), 
                        FileUtils.readFileToString(actualFile, "utf-8"));
        } catch (InvalidArgumentsException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
