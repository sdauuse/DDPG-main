package com.miao.algorithm.lanqiao2;

import java.util.Scanner;

public class ArraySingleLinked {
    static int head = -1;
    static int idx = 0;
    static int N = 100010;
    static int[] ele = new int[N];
    static int[] next = new int[N];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();

        singleLinked(n);
    }

    private static void singleLinked(int n) {

        for (int i = 0; i < n; i++) {
            String op = sc.next();
            if (op.equals("H")) {
                int x = sc.nextInt();
                insert(x);
            } else if (op.equals("D")) {
                int k = sc.nextInt();
                if (k == 0) {
                    head = next[head];
                    continue;
                }
                delete(k - 1);
            } else if (op.equals("I")) {
                int k = sc.nextInt();
                int x = sc.nextInt();
                insert(k - 1, x);
            }
        }


        for (int i = head; i != -1; i = next[i]) {
            System.out.print(ele[i] + " ");
        }
    }

    private static void insert(int x) {
        ele[idx] = x;
        next[idx] = head;
        head = idx;
        idx++;
    }

    private static void delete(int k) {

        next[k] = next[next[k]];

    }

    //表示在第 k 个插入的数后面插入一个数 x（此操作中 k 均大于 0）
    private static void insert(int k, int x) {

        ele[idx] = x;
        next[idx] = next[k];
        next[k] = idx;
        idx++;
    }

}
