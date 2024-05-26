package com.miao.designpattern.singleton;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-21
 * @Copyright：
 */
public class LazySingleton {
    public static void main(String[] args) {
        Single2 instance = Single2.getInstance();
        System.out.println(instance);
    }
}

class Single2 {
    private volatile static Single2 single = null;

    private Single2() {

    }

    public static Single2 getInstance() {
        if (single == null) {
            synchronized (Single2.class) {
                if (single == null) {
                    single = new Single2();
                }
            }
        }

        return single;
    }
}
