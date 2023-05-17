package com.miao.algorithm.lanqiao;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set<Object> set = new HashSet<>();
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(12);
        set.add(3);
        set.add(7);

        /*set.add("sad");
        set.add("aaa");
        set.add("bbb");*/

        Object[] objects = set.toArray();

        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
    }
}
