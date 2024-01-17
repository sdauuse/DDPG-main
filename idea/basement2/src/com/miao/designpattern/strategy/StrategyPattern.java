package com.miao.designpattern.strategy;

public class StrategyPattern {
    public static void main(String[] args) {
        BehaviorContext behavior = new BehaviorContext(new LittlePenguin());
        behavior.everyday();;
        behavior.setPenguin(new MiddlePenguin());
        behavior.everyday();
        behavior.setPenguin(new BigPenguin());
        behavior.everyday();
    }
}
