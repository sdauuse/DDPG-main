package com.miao.algorithm.linear;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    private Node header;
    private Node last;
    private int N;


    private class Node<T> {
        private T item;
        private Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Queue() {
        this.header = new Node(null, null);
        this.last = header;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(T item) {
        Node newNode = new Node(item, null);
        last.next = newNode;
        last = newNode;
        N++;
    }

    public T enqueue() {

        if (isEmpty()) {
            return null;
        }

        Node next = header.next;
        header.next = next.next;

        return (T) next.item;
    }

    public T dequeue() {

        if (isEmpty()) {
            return null;
        }

        Node next = header.next;
        header.next = next.next;

        return (T) next.item;
    }


    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator {
        private Node node;

        public QIterator() {
            this.node = header;
        }

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Object next() {
            node = node.next;
            return node.item;
        }
    }
}
