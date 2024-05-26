package com.miao.designpattern.singleton;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-21
 * @Copyright：
 */
public class StarveSingleton {
    public static void main(String[] args) {
        Single instance = Single.getInstance();
        System.out.println(instance);
    }
}

class Single{
    private static Single single = new Single();
    private Single(){
    }
    public static Single getInstance(){
        return single;
    }
}
