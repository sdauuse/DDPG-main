package com.miao.algorithm.lanqiao3;

import java.util.Scanner;

public class AllSortNumber {
    static final int N = 20;
    static int n;
    static int[] path = new int[N];
    static boolean[] st = new boolean[N];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(0);
    }

    private static void dfs(int u) {

        if (u == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!st[i]) {
                path[u] = i;
                st[i] = true;
                dfs(u + 1);
                st[i] = false;
            }
        }
    }
}
