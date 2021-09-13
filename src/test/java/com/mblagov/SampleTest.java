package com.mblagov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SampleTest {

    @Test
    public void testGetMessage() {
        Sample sample = new Sample();
        assertEquals("My message", sample.getMessage());
    }
}
