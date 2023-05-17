package com.miao.algorithm.lanqiao2;

import java.util.Scanner;

public class MoNiStack {
    static final int N = 100010;
    static int[] stack = new int[N];
    static int top = 0;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int m = sc.nextInt();

        opStack(m);
    }

    private static void opStack(int m) {

        for (int i = 0; i < m; i++) {
            String op = sc.next();
            if (op.equals("push")) {
                int x = sc.nextInt();
                push(x);
            } else if (op.equals("pop")) {
                pop();
            } else if (op.equals("empty")) {
                isEmpty();
            } else if (op.equals("query")) {
                query();
            }
        }
    }

    private static void query() {
        System.out.println(stack[top]);
    }

    private static void pop() {
        int x = stack[top--];
    }

    private static void push(int x) {
        stack[++top] = x;
    }


    private static void isEmpty() {
        if (top == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
