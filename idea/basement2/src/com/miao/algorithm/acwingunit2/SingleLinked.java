package com.miao.algorithm.acwingunit2;

import java.util.Scanner;

public class SingleLinked {
    public static int N = 100010;
    public static int[] ele = new int[N];
    public static int[] next = new int[N];
    public static int idx = 0;
    public static int head = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String op = sc.next();
            if (op.equals("H")) {
                int x = sc.nextInt();
                insert(x);
            } else if (op.equals("I")) {
                int k = sc.nextInt();
                int x = sc.nextInt();
                insert(k - 1, x);
            } else if (op.equals("D")) {
                int k = sc.nextInt();
                if (k == 0) {
                    head = next[head];
                    continue;
                }
                delete(k - 1);
            }
        }

        for (int i = head; i != -1; i = next[i]) {
            System.out.print(ele[i] + " ");
        }
    }

    private static void delete(int k) {
        next[k] = next[next[k]];
    }

    private static void insert(int k, int x) {
        ele[idx] = x;
        next[idx] = next[k];
        next[k] = idx;
        idx++;
    }

    private static void insert(int x) {
        ele[idx] = x;
        next[idx] = head;
        head = idx;
        idx++;
    }
}
