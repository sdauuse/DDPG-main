package com.miao.designpattern.factory;

/**
 * @description:
 * ⼯⼚模式（Factory Pattern）是 Java 中最常⽤的设计模式之⼀。这种类型的设计模式属于创建型模式，它提
 * 供了⼀种创建对象的最佳⽅式。在⼯⼚模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过
 * 使⽤⼀个共同的接⼝来指向新创建的对象。
 * @author：渺阴
 * @date: 2024-01-18
 * @Copyright：
 */
public class FactoryPattern {

    public static void main(String[] args) {
        Penguin _penguin1 = PenguinFactory.getPenguin("littlePenguin");
        _penguin1.everyday();
        Penguin _penguin2 = PenguinFactory.getPenguin("middlePenguin");
        _penguin2.everyday();
        Penguin _penguin3 = PenguinFactory.getPenguin("bigPenguin");
        _penguin3.everyday();
    }
}
