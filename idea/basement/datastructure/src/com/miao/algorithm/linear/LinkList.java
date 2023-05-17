package com.miao.algorithm.linear;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkList<T> implements Iterable<T> {
    //定义头结点
    private Node header;

    //记录链表长度
    private int N;


    private class Node {
        T item;
        Node nextNode;

        public Node(T item, Node nextNode) {
            this.item = item;
            this.nextNode = nextNode;
        }
    }

    public LinkList() {
        this.header = new Node(null, null);
        this.N = 0;
    }

    public void clear() {
        header.nextNode = null;
        N = 0;
    }

    public int length() {
        return N;
    }

    public boolean isEmpty() {
        if (header.nextNode == null) {
            return true;
        } else {
            return false;
        }
    }

    public T get(int i) {

        Node objectNode = header.nextNode;
        for (int index = 0; index < i; index++) {
            objectNode = objectNode.nextNode;
        }
        return objectNode.item;
    }

    public void insert(T item) {
        Node node = header;
        while (node.nextNode != null) {
            node = node.nextNode;
        }

        Node newNode = new Node(item, null);
        node.nextNode = newNode;

        N++;
    }


    //向指定位置i插入元素
    public void insert(T item, int i) {
        Node pre = header;
        for (int index = 0; index < i - 1; index++) {
            pre = pre.nextNode;
        }

        Node newNode = new Node(item, pre.nextNode);
        pre.nextNode = newNode;
        N++;
    }

    public T remove(int i) {
        Node pre = header;
        for (int index = 0; index < i; index++) {
            pre = pre.nextNode;
        }
        T data = pre.nextNode.item;
        pre.nextNode = pre.nextNode.nextNode;
        N--;
        return data;
    }

    //查找元素t在链表中第一次出现的位置
    public int indexOf(T t) {
        Node node = header;

        int index = 0;
        while (node.nextNode != null) {
            node = node.nextNode;
            if (node.item.equals(t)) {
                return index;
            }
            index++;
        }

        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator {
        private Node node;

        public LIterator() {
            this.node = header;
        }

        @Override
        public boolean hasNext() {
            return node.nextNode != null;
        }

        @Override
        public Object next() {
            node = node.nextNode;
            return node.item;
        }
    }

    public void reverse() {

        if (isEmpty()) {
            return;
        }

        reverse(header.nextNode);
    }

    private Node reverse(Node current) {

        if (current.nextNode == null) {
            header.nextNode = current;
            return current;
        }

        Node pre = reverse(current.nextNode);

        pre.nextNode = current;
        current.nextNode = null;

        return current;
    }

}
