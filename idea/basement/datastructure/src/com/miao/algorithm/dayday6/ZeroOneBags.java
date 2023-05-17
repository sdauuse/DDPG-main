package com.miao.algorithm.dayday6;

import java.util.Scanner;

@SuppressWarnings("all")
public class ZeroOneBags {
    static final int N = 1010;
    static int[][] dp = new int[N][N];

    //第i件物品的重量
    static int[] w = new int[N];
    //第i件物品的价值
    static int[] v = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            int weight = sc.nextInt();
            int val = sc.nextInt();
            w[i] = weight;
            v[i] = val;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
