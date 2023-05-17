package com.miao.algorithm.linear;

import java.util.Iterator;

public class SequenceList<T> implements Iterable<T> {
    private T[] elements;
    private int N;

    public SequenceList(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.N = 0;
    }

    //将一个线性表置为空表
    public void clear() {
        this.N = 0;

    }

    private void resize(int capacity) {
        T[] temp = elements;
        elements = (T[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            elements[i] = temp[i];
        }
    }


    public boolean isEmpty() {
        if (N == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int length() {
        return N;
    }

    //获取指定位置元素
    public T get(int i) {
        return this.elements[i];
    }

    public void insert(T t) {
        if (N == elements.length) {
            resize(elements.length * 2);
        }

        this.elements[N++] = t;
    }

    //在i元素处插入元素t
    public void insert(int i, T t) {
        if (N == elements.length) {
            resize(elements.length * 2);
        }

        for (int j = N; j > i; j--) {
            this.elements[j] = this.elements[j - 1];
        }
        this.elements[i] = t;
        N++;
    }

    //删除指定位置i的元素
    public T delete(int i) {
        if (N < elements.length / 4) {
            resize(elements.length / 2);
        }

        T t = elements[i];
        for (int j = i; j < N - 1; j++) {
            elements[j] = elements[j + 1];
        }
        N--;
        return t;
    }

    //查找元素t第一次出现的位置
    public int indexOf(T t) {
        for (int i = 0; i < N; i++) {
            if (elements[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {

        private int cursor;

        public SIterator() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return cursor < N;
        }

        @Override
        public Object next() {
            return elements[cursor++];
        }
    }
}
