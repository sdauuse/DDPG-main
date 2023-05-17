package com.miao.algorithm.test;

import com.miao.algorithm.linear.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> q = new Queue<>();

        q.enqueue("aaaa");
        q.enqueue("bbbb");
        q.enqueue("cccc");
        q.enqueue("ddddd");

        System.out.println(q.size());
        System.out.println(q.isEmpty());

        for (String s : q) {
            System.out.println(s);
        }

        System.out.println("--------------------");

    }
}
