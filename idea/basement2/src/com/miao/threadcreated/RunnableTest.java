package com.miao.threadcreated;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-21
 * @Copyright：
 */
public class RunnableTest {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        Thread t1 = new Thread(mr);
        t1.start();
    }
}

class MyRunnable implements  Runnable{

    @Override
    public void run() {
        System.out.println("this is MyRunnable");
    }
}
