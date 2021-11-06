package com.pajehyk.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MyStackTest {
    private Integer[] array = {1, 2, 3, 4, 5};  
    private MyStack<Integer> stack = new MyStack<Integer>(array);

    @Test
    public void popTest() {
        Integer[] anotherArray = {1, 2, 3, 4};
        MyStack<Integer> anotherStack = new MyStack<Integer>(anotherArray);
        int element = stack.pop();
        assertEquals(anotherStack, stack);
        assertEquals(element, 5);
    }
    @Test
    public void pushTest() {
        Integer[] anotherArray = {1, 2, 3, 4, 5, 6};
        MyStack<Integer> anotherStack = new MyStack<Integer>(anotherArray);
        stack.push(6);
        assertEquals(anotherStack, stack);
    }
    @Test
    public void peekTest() {
        int element = stack.peek();
        assertEquals(element, 5);
    }
}
