package com.pajehyk.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinearListTest {
    private Integer[] array;
    private LinearList<Integer> list;
    @BeforeEach
    public void initMethod() {
        array = new Integer[5];
        for (int i = 0; i < 5; i++) {
            array[i] = i;
        }
        list = new LinearList<Integer>(array);
    }
    @Test
    public void addTest() {
        Integer[] anotherArray = new Integer[6];
        for (int i=0; i < 6; i++) {
            anotherArray[i] = i;
        }
        LinearList<Integer> anotherList = new LinearList<Integer>(anotherArray);
        list.add(5);
        assertEquals(list, anotherList);
    }
    @Test
    public void addByIndexTest() {
        Integer[] anotherArray = new Integer[6];
        for (int i=0; i < 6; i++) {
            if (i < 2) {
                anotherArray[i] = i;
            }
            if (i > 2) {
                anotherArray[i] = i-1;
            }
        }
        anotherArray[2] = 10;
        LinearList<Integer> anotherList = new LinearList<Integer>(anotherArray);
        list.add(2, 10);
        System.out.println(list);
        System.out.println(anotherList);
        assertEquals(list, anotherList);
    }
    @Test
    public void indexOfTest() {
        int index = list.indexOf(4);
        assertEquals(4, index);
    }
    @Test
    public void sizeTest() {
        int size = list.size();
        assertEquals(5, size);
    }
    @Test
    public void equalsTest() {
        Integer[] anotherArray = new Integer[5];
        for (int i=0; i < 5; i++) {
            anotherArray[i] = i;
        }
        LinearList<Integer> anotherList = new LinearList<Integer>(anotherArray);
        assertTrue(list.equals(anotherList));
    }
}
