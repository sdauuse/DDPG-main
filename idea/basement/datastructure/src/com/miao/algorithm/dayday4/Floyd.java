package com.miao.algorithm.dayday4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Floyd {
    static final int N = 220;
    static final int M = 20010;

    static int idx = 0;
    static int[][] g = new int[N][N];
    static final int INF = 0x3f3f3f3f;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    g[i][j] = 0;
                } else {
                    g[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            String[] s1 = bf.readLine().split(" ");
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);
            int z = Integer.parseInt(s1[2]);
            g[x][y] = Math.min(g[x][y], z);
        }

        floyd(n);

        for (int i = 0; i < k; i++) {
            String[] s1 = bf.readLine().split(" ");
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);
            if (g[x][y] > INF / 2) {
                System.out.println("impossible");
            } else {
                System.out.println(g[x][y]);
            }
        }
    }

    private static void floyd(int n) {

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
    }
}
