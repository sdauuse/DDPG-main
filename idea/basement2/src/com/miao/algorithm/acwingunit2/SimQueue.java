package com.miao.algorithm.acwingunit2;

import java.util.Scanner;

public class SimQueue {
    public static int N = 100010;
    public static int[] q = new int[N];
    static int head = 0;
    static int tail = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String op = sc.next();
            if (op.equals("push")) {
                int x = sc.nextInt();
                push(x);
            } else if (op.equals("pop")) {
                pop();
            } else if (op.equals("empty")) {
                empty();
            } else if (op.equals("query")) {
                query();
            }
        }
    }

    private static void query() {
        int res = q[head];
        System.out.println(res);
    }

    private static void empty() {
        if (tail==head){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }

    private static void pop() {
        assert head <= tail;
        int res = q[head];
        head++;
    }

    private static void push(int x) {
        q[tail] = x;
        tail++;
    }
}
