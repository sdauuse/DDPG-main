package com.miao.designpattern.factory;

public abstract class Penguin {
    public void eating() {
        System.out.println("吃饭");
    }

    public void sleeping() {
        System.out.println("睡觉");
    }

    public abstract void beating();

    public void everyday(){
        eating();
        sleeping();
        beating();
    }
}
