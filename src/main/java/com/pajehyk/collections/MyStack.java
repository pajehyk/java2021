package com.pajehyk.collections;

import java.util.Stack;

/**
 * Generic class MyStack is a custom stack-based structure, extending java.util.Stack class.
 */
public class MyStack<T> extends Stack<T> {
    LinearList<T> list = new LinearList<>();

    /**
     * peek() method returns top element of the stack and does not edit instance of an object.
     */
    public T peek() {
        return list.get(list.size() - 1);
    }

    /**
     * pop() method returns top element and removes it from the stack.
     */
    public T pop() {
        T element = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return element;
    }

    /**
     * push() method adds new element on top of the stack and returns this element.
     */
    public T push(T element) {
        list.add(element);
        return element;
    }

    /**
     * toString() method returns stack in a string format.
     */
    @Override
    public String toString() {
        return list.toString();
    }
}
