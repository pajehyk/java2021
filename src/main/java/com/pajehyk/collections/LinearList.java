package com.pajehyk.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Arrays;
import java.lang.UnsupportedOperationException;

public class LinearList<T> implements List<T>{
    private Object[] contentArray;
    private int size;

    public LinearList() {
        contentArray = new Object[0];
    }
    @Override
    public boolean add(T e) {
        contentArray = Arrays.copyOf(contentArray, size + 1);
        contentArray[size] = e;
        size++;
        return true;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) return true;
        else return false;
    }

    @Override
    public T get(int index) {
        return (T)contentArray[index];
    }

    @Override
    public void add(int index, T element) {
        contentArray = Arrays.copyOf(contentArray, size + 1);
        for (int i = index+1; i < size + 1; i++) {
            contentArray[i] = contentArray[i-1];
        }
        contentArray[index] = element;
        size++;
    }

    @Override
    public T remove(int index) {
        T e = (T)contentArray[index];
        for (int i = index; i < size - 1; i++) {
            contentArray[i] = contentArray[i+1];
        }
        contentArray = Arrays.copyOf(contentArray, size - 1);
        size--;
        return e;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (contentArray[i] == o) return i;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override 
    public String toString() {
        String returningString = "{";
        for (int i = 0; i < size - 1; i++) {
            returningString += contentArray[i] + ", ";
        }
        returningString += contentArray[size - 1] + "}";
        return returningString;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}
