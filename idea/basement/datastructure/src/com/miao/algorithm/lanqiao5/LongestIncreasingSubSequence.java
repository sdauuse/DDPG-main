package com.miao.algorithm.lanqiao5;

import java.util.Scanner;

public class LongestIncreasingSubSequence {

    static final int N = 1010;
    static int[] dp = new int[N];
    static int[] a = new int[N];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        //dp[i] 表示以i结尾的最长上升子序列

        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = (int) (-1e9 - 8);
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
