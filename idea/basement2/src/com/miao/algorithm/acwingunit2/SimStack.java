package com.miao.algorithm.acwingunit2;

import java.util.Scanner;

public class SimStack {
    public static int N = 100010;
    public static int[] stack = new int[N];
    public static int top = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String op = sc.next();
            if (op.equals("push")) {
                int x = sc.nextInt();
                push(x);
            } else if (op.equals("pop")) {
                int res = pop();
            } else if (op.equals("empty")) {
                empty();
            } else if (op.equals("query")) {
                query();
            }
        }
    }

    private static void empty() {
        if (top == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void query() {
        System.out.println(stack[top]);
    }

    private static int pop() {
        //VM参数 -ea 才可以生效
        assert top != 0;
        int res = stack[top];
        top--;
        return res;
    }


    private static void push(int x) {
        top++;
        stack[top] = x;
    }
}
