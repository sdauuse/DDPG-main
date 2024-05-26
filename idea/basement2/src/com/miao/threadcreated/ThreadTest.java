package com.miao.threadcreated;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-21
 * @Copyright：
 */
public class ThreadTest {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println("aaaa");
        });

        t.start();
    }
}
