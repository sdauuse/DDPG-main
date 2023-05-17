package com.miao.algorithm.acwing1;

import java.util.Arrays;
import java.util.Scanner;

public class Floyd {
    static int N = 210;
    static int[][] g = new int[N][N];

    static int INF = 0x3f3f3f3f;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < N; i++) {
            Arrays.fill(g[i], INF);
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            g[a][b] = Math.min(g[a][b], c);
        }

        floyd(n, m);

        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (g[a][b] > INF / 2) {
                System.out.println("impossible");
            } else {
                System.out.println(g[a][b]);
            }
        }
    }

    private static void floyd(int n, int m) {

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
    }
}
