package com.miao.algorithm.lanqiao5;

import java.util.Scanner;

public class OneZeroBags {

    static final int N = 1010;
    static int[][] dp = new int[N][N];
    static int[] V = new int[N];
    static int[] W = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int v = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            V[i] = sc.nextInt();
            W[i] = sc.nextInt();
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= v; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j >= V[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - V[i]] + W[i]);
                }

            }
        }

        System.out.println(dp[n][v]);
    }
}
