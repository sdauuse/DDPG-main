package com.miao.algorithm.dayday6;

import java.util.Scanner;

@SuppressWarnings("all")
public class ZeroOneBagsOneDim {
    static final int N = 1010;
    static int[] dp = new int[N];

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
            for (int j = m; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }

        System.out.println(dp[m]);
    }
}
