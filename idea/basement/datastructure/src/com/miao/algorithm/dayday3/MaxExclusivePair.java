package com.miao.algorithm.dayday3;

import java.util.Scanner;

public class MaxExclusivePair {
    static final int N = 100010;
    static final int M = 31 * N;
    static int[][] son = new int[M][2];
    static int[] a = new int[N];
    static int idx = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            insert(a[i]);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(query(a[i]), max);
        }

        System.out.println(max);
    }

    private static int query(int x) {
        int res = 0;
        int p = 0;

        for (int i = 30; i >= 0; i--) {
            int u = x >> i & 1;
            if (son[p][u ^ 1] != 0) {
                res = res + (1 << i);
                p = son[p][u^1];
            } else {
                p = son[p][u];
            }
        }
        return res;
    }

    private static void insert(int x) {
        int p = 0;
        for (int i = 30; i >= 0; i--) {
            int u = son[p][(x >> i) & 1];
            if (u == 0) {
                son[p][(x >> i) & 1] = ++idx;
            }
            p = son[p][(x >> i) & 1];
        }
    }


}
