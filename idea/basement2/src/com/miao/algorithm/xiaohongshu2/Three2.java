package com.miao.algorithm.xiaohongshu2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-04-12
 * @Copyright：
 */
public class Three2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = bf.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        String line2 = bf.readLine();

        int[][] dp = new int[n][m + 1];
        int mod = 1000000007;

        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (line2.charAt(i - 1) == '<') {
                for (int j = 1; j <= m; j++) {
                    for (int k = 1; k < j; k++) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
                    }
                }
            } else if (line2.charAt(i - 1) == '>') {
                for (int j = 1; j <= m; j++) {
                    for (int k = j; k <= m; k++) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
                    }
                }
            } else {
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= m; i++) {
            res = (res + dp[n - 1][i]) % mod;
        }
        System.out.println(res);
    }
}
