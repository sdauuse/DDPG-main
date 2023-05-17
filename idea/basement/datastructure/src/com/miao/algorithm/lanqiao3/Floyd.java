package com.miao.algorithm.lanqiao3;

import java.util.Scanner;

public class Floyd {
    static final int N = 220;
    static final int INF = 0x3f3f3f3f;
    static int[][] dp = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            dp[a][b] = Math.min(dp[a][b], c);
        }

        floyd(n);

        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (dp[a][b] > INF / 2) {
                System.out.println("impossible");
            } else {
                System.out.println(dp[a][b]);
            }
        }
    }

    private static void floyd(int n) {

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
    }

}
