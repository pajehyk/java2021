package com.pajehyk.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class LinearListTest {
    @Test
    public void addTest() {
        Integer[] array = new Integer[5];
        Integer[] anotherArray = new Integer[6];
        for (int i=0; i<5; i++) {
            array[i] = i;
            anotherArray[i] = i;
        }
        anotherArray[5] = 5;
        LinearList<Integer> list = new LinearList<Integer>(array);
        LinearList<Integer> anotherList = new LinearList<Integer>(anotherArray);
        list.add(5);
        assertEquals(list, anotherList);
    }
}
