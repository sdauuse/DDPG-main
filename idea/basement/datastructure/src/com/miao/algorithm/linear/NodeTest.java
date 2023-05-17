package com.miao.algorithm.linear;

public class NodeTest<T> {
    public T element;
    public NodeTest nextNode;

    public NodeTest(T element, NodeTest nextNode) {
        this.element = element;
        this.nextNode = nextNode;
    }
}
