package com.miao.algorithm.symbol;

import java.util.Iterator;

public class OrderSymbolTable<Key extends Comparable<Key>, Value> implements Iterable<Value> {

    private Node header;
    private int N;


    private class Node {
        public Key key;
        public Value value;
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public OrderSymbolTable() {
        this.header = new Node(null, null, null);
        this.N = 0;
    }

    public int size() {
        return N;
    }


    public void put(Key key, Value value) {
        Node current = header.next;
        Node before = header;
        while (current != null && key.compareTo(current.key) > 0) {
            before = current;
            current = current.next;
        }

        if (current != null && key.compareTo(current.key) == 0) {
            current.value = value;
            return;
        }

        Node newNode = new Node(key, value, current);
        before.next = newNode;
        N++;
    }

    public void delete(Key key) {
        Node n = header;
        while (n.next != null) {
            Node before = n;
            n = n.next;
            if (n.key.equals(key)) {
                before.next = n.next;
                N--;
                return;
            }
        }
    }

    public Value get(Key key) {
        Node n = header;
        while (n.next != null) {
            n = n.next;
            if (n.key.equals(key)) {
                return n.value;
            }
        }

        return null;
    }

    @Override
    public Iterator<Value> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {
        private Node node;

        public SIterator() {
            this.node = header;
        }

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Object next() {
            node = node.next;
            return node.value;
        }
    }
}

