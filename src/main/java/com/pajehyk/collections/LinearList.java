package com.pajehyk.collections;

import java.lang.UnsupportedOperationException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.lang.IndexOutOfBoundsException;

/**
 * LinearList is a generic class that implements java.util.List class.
 */
public class LinearList<T> implements List<T> {
    private Object[] contentArray;
    private int size;
    private int arraySize;

    /**
     * Constructor with no arguments, creates an empty instance of a class.
     */
    public LinearList() {
        contentArray = new Object[0];
        arraySize = 0;
        size = 0;
    }

    /**
     * Constructor with array argument.
     *
     * @param array generic array that fills contentArray
     */
    public LinearList(T[] array) {
        arraySize = array.length;
        size = array.length;
        contentArray = Arrays.copyOf(array, array.length);
    }

    /**
     * resize() method changes size of an containing array by multiplying it by 2.
     */
    private void resize() {
        int newArraySize;
        if (arraySize == 0) {
            newArraySize = 1;
        } else {
            newArraySize = arraySize * 2;
        }
        contentArray = Arrays.copyOf(contentArray, newArraySize);
        arraySize = newArraySize;
    }

    /**
     * add(T e) method adds element to the end of containing array
     * and automatically resizes an array if needed.
     */
    @Override
    public boolean add(T e) {
        if (size + 1 > arraySize) {
            resize();
        }
        contentArray[size] = e;
        size++;
        return true;
    }

    /**
     * add(int index, T element) method adds element and places it according to the index argument.
     */
    @Override
    public void add(int index, T element) {
        if (size + 1 > arraySize) {
            resize();
        }
        System.arraycopy(contentArray, index, contentArray, index+1, size - index);
        contentArray[index] = element;
        size++;
    }

    /**
     * isEmpty() method returns true if containing array is not empty and false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * get(int index) method returns element accessing it by index.
     */
    @Override
    public T get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) contentArray[index];
    }

    /**
     * remove(int index) method removes element by its index.
     */
    @Override
    public T remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T e = (T) contentArray[index];
        System.arraycopy(contentArray, index+1, contentArray, index, size - index - 1);
        size--;
        return e;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    /**
     * returns index of a given element if it exists, return -1 otherwise.
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (contentArray[i] == o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * converts containing array to a string and returns it.
     */
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
    public boolean equals(Object o) {
        if (o.getClass().equals(this.getClass())) {
            LinearList<T> objectList = (LinearList<T>) o;
            if (this.size == objectList.size) {
                for (int i = 0; i < size; i++) {
                    if (this.get(i) != objectList.get(i)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
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
