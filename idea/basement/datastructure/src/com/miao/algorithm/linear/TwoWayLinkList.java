package com.miao.algorithm.linear;

import java.util.Iterator;

public class TwoWayLinkList<T> implements Iterable<T> {
    private Node header;
    private Node last;
    private int N;


    private class Node {
        public T item;
        public Node pre;
        public Node next;

        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    public TwoWayLinkList() {
        this.header = new Node(null, null, null);
        this.last = null;
        this.N = 0;
    }


    public void clear() {
        this.header.next = null;
        this.last = null;
        this.N = 0;
    }

    public int length() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public T getFirst() {
        if (isEmpty()) {
            return null;
        } else {
            return header.next.item;
        }
    }

    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return last.item;
    }

    public void insert(T t) {

        Node node;
        if (last != null) {
            node = new Node(t, last, null);
            last.next = node;
        } else {
            node = new Node(t, header, null);
            header.next = node;
        }
        last = node;
        N++;

    }

    public void insert(int i, T t) {
        Node pre = header;
        for (int index = 0; index < i; index++) {
            pre = pre.next;
        }
        Node newNode = new Node(t, pre, pre.next);
        pre.next = newNode;

        N++;

    }

    public T get(int i) {
        Node node = header.next;
        for (int index = 0; index < i; index++) {
            node = node.next;
        }
        return node.item;
    }

    public int indexOf(T t) {
        Node node = header.next;
        int index = 0;
        while (node.next != null) {
            if (node.item.equals(t)) {
                return index;
            }

            index++;
            node = node.next;
        }
        return -1;
    }

    public T remove(int i) {
        Node pre = header;
        for (int index = 0; index < i; index++) {
            pre = pre.next;
        }

        Node cur = pre.next;
        cur.next.pre = pre;
        pre.next = cur.next;

        N--;
        return cur.item;
    }


    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }

    private class TIterator implements Iterator {

        private Node node;

        public TIterator() {
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
