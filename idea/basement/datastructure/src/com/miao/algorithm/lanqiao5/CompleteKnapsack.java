package com.miao.algorithm.lanqiao5;

import java.util.Scanner;

public class CompleteKnapsack {
    static final int N = 1010;
    static int[][] dp = new int[N][N];
    static int[] v = new int[N];
    static int[] w = new int[N];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int vol = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= vol; j++) {
                for (int k = 0; k * v[i] <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * v[i]] + k * w[i]);
                }
            }
        }

        System.out.println(dp[n][vol]);
    }
}
