package com.miao.algorithm.repeat;

import java.util.Arrays;
import java.util.Scanner;

public class NQueens {
    static final int N = 20;
    static char[][] g = new char[N][N];
    static boolean[] dg = new boolean[N];
    static boolean[] udg = new boolean[N];
    static boolean[] col = new boolean[N];

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < N; i++) {
            Arrays.fill(g[i], '.');
        }

        dfs(0);
    }

    private static void dfs(int u) {

        if (u == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(g[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        int x = u;
        for (int y = 0; y < n; y++) {

            if (!col[y] && !dg[y-x+n] && !udg[y+x]){
                col[y] = dg[y-x+n] = udg[y+x] = true;
                g[x][y] = 'Q';
                dfs(u+1);
                col[y] = dg[y-x+n] = udg[y+x] = false;
                g[x][y] = '.';
            }
        }

    }
}
