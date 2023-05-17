package com.miao.algorithm.lanqiao5;

import java.util.Scanner;

public class MultiKnapsack {
    static final int N = 110;
    static int[][] dp = new int[N][N];
    static int[] W = new int[N];
    static int[] V = new int[N];
    static int[] K = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int v = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            V[i] = sc.nextInt();
            W[i] = sc.nextInt();
            K[i] = sc.nextInt();

        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= v; j++) {
                //dp[i][j] = dp[i - 1][j];
                for (int k = 0; k <= K[i]; k++) {
                    if (V[i] * k <= j) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - V[i] * k] + k * W[i]);
                    }
                }
            }
        }

        System.out.println(dp[n][v]);
    }
}
