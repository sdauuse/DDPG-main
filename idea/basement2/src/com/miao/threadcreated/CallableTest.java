package com.miao.threadcreated;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-21
 * @Copyright：
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable mc = new MyCallable();
        FutureTask ft = new FutureTask(mc);
        Thread t1 = new Thread(ft);
        t1.start();

        Object o = ft.get();
        System.out.println(o);
    }
}

class MyCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("this is callable");
        return "return number";
    }
}
