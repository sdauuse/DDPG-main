package com.miao.algorithm.lanqiao3;

import java.util.Scanner;

public class NQueen {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static final int N = 20;
    static char[][] g = new char[n][n];
    static boolean[] col = new boolean[N];
    static boolean[] dg = new boolean[N];
    static boolean[] udg = new boolean[N];

    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = '.';
            }
        }
        dfs(0);
    }

    private static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                System.out.println(g[i]);
            }
            System.out.println();
            return;
        }
        int x = u;

        for (int y = 0; y < n; y++) {
            if (!col[y] && !dg[y - x + n] && !udg[y + x]) {
                col[y] = dg[y - x + n] = udg[y + x] = true;
                g[x][y] = 'Q';
                dfs(u + 1);
                g[x][y] = '.';
                col[y] = dg[y - x + n] = udg[y + x] = false;
            }
        }

    }
}
