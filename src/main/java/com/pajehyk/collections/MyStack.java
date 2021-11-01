package com.pajehyk.collections;

import java.util.Stack;

public class MyStack<T> extends Stack<T> {
    LinearList<T> list = new LinearList<>();

    public T peek() {
        return list.get(list.size() - 1);
    }

    public T pop() {
        T element = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return element;
    }

    public T push(T element) {
        list.add(element);
        return element;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
