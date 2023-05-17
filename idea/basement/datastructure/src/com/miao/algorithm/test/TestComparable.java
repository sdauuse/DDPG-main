package com.miao.algorithm.test;

import com.miao.algorithm.sort.Student;

public class TestComparable {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setAge(20);
        s1.setUsername("张三");

        Student s2 = new Student();
        s2.setUsername("lky");
        s2.setAge(24);

        Comparable max = getMax(s1, s2);
        System.out.println(max);
    }

    public static Comparable getMax(Comparable c1, Comparable c2) {
        int i = c1.compareTo(c2);
        if (i > 0) {
            return c1;
        } else {
            return c2;
        }
    }
}
