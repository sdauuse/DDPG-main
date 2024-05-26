package com.miao.algorithm.xiaohongshu2;

import java.util.Scanner;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-04-12
 * @Copyright：
 */
public class Three {
    private static int mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();

        int res = ops(n, m, s);
        System.out.println(res);
    }

    private static int ops(int n, int m, String s) {
        int[][] dp = new int[n + 1][m + 1];

        for (int j = 0; j <= m; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= n; i++) {
            char r = s.charAt(i - 2);
            int[] preSum = new int[m + 2];

            for (int j = 1; j <= m; j++) {
                preSum[j] = (preSum[j - 1] + dp[i - 1][j]) % mod;
            }

            for (int j = 1; j <= m; j++) {
                if (r == '<') {
                    dp[i][j] = preSum[j - 1];
                } else if (r == '>') {
                    dp[i][j] = (preSum[m] - preSum[j] + mod) % mod;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int res = 0;
        for (int j = 1; j <= m; j++) {
            res = (res + dp[n][j]) % mod;
        }
        return res;
    }
}
