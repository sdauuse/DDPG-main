package com.miao.designpattern.template;

/**
 * 在模板模式（Template Pattern）中，⼀个抽象类公开定义了执⾏它的⽅法的⽅式/模板。它的⼦类可以按需
 * 要重写⽅法实现，但调⽤将以抽象类中定义的⽅式进⾏。这种类型的设计模式属于⾏为型模式。
 */
public class TemplatePattern {
    public static void main(String[] args) {
        System.out.println("littlePenguin:");
        Penguin penguin1 = new LittlePenguin();
        penguin1.everyday();
        System.out.println("middlePenguin:");
        Penguin penguin2 = new MiddlePenguin();
        penguin2.everyday();
        System.out.println("bigPenguin:");
        Penguin penguin3 = new BigPenguin();
        penguin3.everyday();
    }
}
