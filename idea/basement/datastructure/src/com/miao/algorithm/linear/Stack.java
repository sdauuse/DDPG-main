package com.miao.algorithm.linear;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private Node header;
    private int N;


    private class Node<T> {
        private T item;
        private Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Stack() {
        this.header = new Node(null, null);
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    //头插法建立栈
    public void push(T item) {

        Node newNode = new Node(item, header.next);
        header.next = newNode;
        N++;
    }

    public T pop() {

        if (header.next != null) {
            T result = (T) header.next.item;
            header.next = header.next.next;
            N--;
            return result;
        } else {
            return null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {
        private Node n;

        public SIterator() {
            n = header;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }
}
