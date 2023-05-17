package com.miao.algorithm.lanqiao5;

import java.util.Scanner;

public class LongestCommonSequence {

    static final int N = 1010;
    static int[][] dp = new int[N][N];
    static char[] a = new char[N];
    static char[] b = new char[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String as = sc.next();
        String bs = sc.next();
        for (int i = 0; i < n; i++) {
            a[i + 1] = as.charAt(i);
        }

        for (int i = 0; i < m; i++) {
            b[i + 1] = bs.charAt(i);
        }

        longestCommonSequence(n, m);
    }

    private static void longestCommonSequence(int n, int m) {
        //dp[n][m] 表示第一个字符串前n项，与第二个字符串前m项的最长公共子序列
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if (a[i] == b[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
