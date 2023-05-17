package com.miao.algorithm.test;

import com.miao.algorithm.linear.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        stack.push("aaaa");
        stack.push("bbbb");
        stack.push("ccccc");
        stack.push("dddd");

        String pop = stack.pop();
        System.out.println("弹出的元素是:" + pop);


        for (String s : stack) {
            System.out.println(s);
        }
        System.out.println("--------------------");


    }
}
