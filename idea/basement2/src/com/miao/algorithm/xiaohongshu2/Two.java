package com.miao.algorithm.xiaohongshu2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-04-12
 * @Copyright：
 */
public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        long[] fans = new long[n];
        for (int i = 0; i < n; i++) {
            fans[i] = sc.nextInt();
        }
        long res = ops(n, x, fans);
        System.out.println(res);
    }

    private static long ops(int n, int x, long[] fans) {
        int[] dp = new int[x + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (long fan : fans) {
            long hf = fan / 2;
            for (int j = x; j >= hf; j--) {
                if (dp[(int) (j - hf)] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[(int) (j - hf)] + 1, dp[j]);
                }
            }
        }

        for (long fan : fans) {
            for (int j = x; j >= fan; j--) {
                if (dp[(int) (j - fan)] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[(int) (j - fan)] + 1, dp[j]);
                }
            }
        }

        return dp[x] == Integer.MAX_VALUE ? -1 : dp[x];
    }
}
