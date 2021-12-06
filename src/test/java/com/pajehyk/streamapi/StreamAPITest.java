package com.pajehyk.streamapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

public class StreamAPITest {
    @Test
    public void testCountToFile() throws IOException {
        StreamAPI.countToFile("src/test/resources/text.txt", "src/test/resources/actualCounts.txt");
        assertEquals(FileUtils.readFileToString(new File("src/test/resources/expectedCounts.txt"), "utf-8"), 
        FileUtils.readFileToString(new File("src/test/resources/actualCounts.txt"), "utf-8"));
    }
}