package com.mblagov;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * A test for a <code>com.mblagov.Sample</code> class.
 */
public class SampleTest {

    @Test
    public void testGetMessage() {
        Sample sample = new Sample();
        assertEquals("My message", sample.getMessage());
    }
}
