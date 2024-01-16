package com.miao.algorithm.acwingunit2;

import java.util.Scanner;

public class DoubleLinked {
    public static int N = 100010;
    public static int[] ele = new int[N];
    public static int[] next = new int[N];
    public static int[] pre = new int[N];
    public static int head = 0;
    public static int tail = N - 1;
    public static int idx = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        pre[tail] = head;
        next[head] = tail;
        for (int i = 0; i < m; i++) {
            String op = sc.next();
            if (op.equals("L")) {
                int x = sc.nextInt();
                insert(head, x);
            } else if (op.equals("R")) {
                int x = sc.nextInt();
                insert(pre[tail], x);
            } else if (op.equals("D")) {
                int k = sc.nextInt();
                delete(k);
            } else if (op.equals("IL")) {
                int k = sc.nextInt();
                int x = sc.nextInt();
                insert(pre[k], x);
            } else if (op.equals("IR")) {
                int k = sc.nextInt();
                int x = sc.nextInt();
                insert(k, x);
            }
        }


        int p = next[head];
        while (p != tail) {
            System.out.print(ele[p] + " ");
            p = next[p];
        }
    }

    private static void insert(int k, int x) {
        ele[idx] = x;
        pre[idx] = k;
        next[idx] = next[k];
        pre[next[k]] = idx;
        next[k] = idx;
        idx++;
    }

    private static void delete(int k) {
        next[pre[k]] = next[k];
        pre[next[k]] = pre[k];
    }
}
