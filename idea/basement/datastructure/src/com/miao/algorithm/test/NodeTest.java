package com.miao.algorithm.test;

public class NodeTest {
    public static void main(String[] args) {
        com.miao.algorithm.linear.NodeTest<Integer> first = new com.miao.algorithm.linear.NodeTest<>(1, null);
        com.miao.algorithm.linear.NodeTest<Integer> second = new com.miao.algorithm.linear.NodeTest<>(2, null);
        com.miao.algorithm.linear.NodeTest<Integer> third = new com.miao.algorithm.linear.NodeTest<>(3, null);
        com.miao.algorithm.linear.NodeTest<Integer> fourth = new com.miao.algorithm.linear.NodeTest<>(4, null);


        first.nextNode = second;
        second.nextNode = third;
        third.nextNode = fourth;
    }
}
