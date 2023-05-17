package com.miao.algorithm.lanqiao2;

import java.util.Scanner;

public class MoNiQueue {

    static final int N = 100010;
    static int head = 0;
    static int tail = 1;
    static int[] queue = new int[N];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int m = sc.nextInt();

        opQueue(m);
    }

    private static void opQueue(int m) {

        for (int i = 0; i < m; i++) {
            String op = sc.next();
            if (op.equals("push")) {
                int x = sc.nextInt();
                push(x);
            } else if (op.equals("empty")) {
                isEmpty();
            } else if (op.equals("query")) {
                query();
            } else if (op.equals("pop")) {
                pop();
            }
        }
    }

    private static void pop() {
        head++;
    }

    private static void query() {
        int index = head + 1;
        System.out.println(queue[index]);
    }

    private static void push(int x) {
        queue[tail] = x;
        tail++;
    }

    private static void isEmpty() {
        if (head + 1 == tail) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
