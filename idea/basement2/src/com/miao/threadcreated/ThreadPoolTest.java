package com.miao.threadcreated;

import java.util.concurrent.*;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-21
 * @Copyright：
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        MyRun myRun = new MyRun();
//        ExecutorService e = Executors.newFixedThreadPool(2);
//        e.submit(myRun);
//        e.shutdown();
        ArrayBlockingQueue<Runnable> myRuns = new ArrayBlockingQueue<>(2);
        ThreadPoolExecutor toe = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS,myRuns);
        toe.submit(myRun);
        toe.shutdown();
    }

}

class MyRun implements Runnable {

    @Override
    public void run() {
        System.out.println("this is a test");
    }
}