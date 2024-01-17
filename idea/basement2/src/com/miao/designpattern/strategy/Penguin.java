package com.miao.designpattern.strategy;

public abstract class Penguin {
    public void eating() {
        System.out.println("吃饭");
    }

    public void sleeping() {
        System.out.println("睡觉");
    }

    public abstract void beating();

}
