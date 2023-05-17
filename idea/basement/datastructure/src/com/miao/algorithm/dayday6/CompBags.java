package com.miao.algorithm.dayday6;

import java.util.Scanner;

public class CompBags {
    static final int N = 1010;
    static int[][] dp = new int[N][N];
    static int[] w = new int[N];
    static int[] v = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int weight = sc.nextInt();
            int value = sc.nextInt();
            w[i] = weight;
            v[i] = value;
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k * w[i] <= j; k++) {
                    //dp[i - 1][j - k * w[i]] + k * v[i]把dp[i-1][j]的情况包括了
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * w[i]] + k * v[i]);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
