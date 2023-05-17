package com.miao.algorithm.dayday3;

import java.util.Arrays;
import java.util.Scanner;

public class MaxExclusiveSum {
    static final int N = 100010;
    static final int M = 32 * N;
    static int idx = 0;

    static int[] a = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int max = 0;

        for (int i = 0; i + m < n; i++) {
            int[][] son = new int[M][2];
            for (int j = i; j < i + m; j++) {
                insert(son, a[j]);
            }
            int res = 0;
            for (int j = i; j < i + m; j++) {
                res = res + query(son, a[j]);
            }
            max = Math.max(res, max);
        }

        System.out.println(max);
    }

    private static int query(int[][] son, int x) {
        int p = 0;
        int res = 0;
        for (int i = 30; i >= 0; i--) {
            int u = (x >> i) & 1;
            if (son[p][u ^ 1] != 0) {
                res = res + (1 << i);
                p = son[p][u ^ 1];
            } else {
                p = son[p][u];
            }
        }
        return res;
    }

    private static void insert(int[][] son, int x) {
        int p = 0;

        for (int i = 30; i >= 0; i--) {
            int t = (x >> i) & 1;
            if (son[p][t] == 0) {
                son[p][t] = ++idx;
            }
            p = son[p][t];
        }
    }
}
