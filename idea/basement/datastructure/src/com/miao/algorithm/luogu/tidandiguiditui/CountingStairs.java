package com.miao.algorithm.luogu.tidandiguiditui;

import java.math.BigInteger;
import java.util.Scanner;

public class CountingStairs {
    static int N = 5010;
    static long res = 0;
    static int n;
    static BigInteger[] dp = new BigInteger[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        //用long会超出范围
        dp[1] = new BigInteger("1");
        dp[0] = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        System.out.println(dp[n]);

        /*dfs(0);
        System.out.println(res);*/

    }


    //dfs会超时
    private static void dfs(int u) {
        if (u >= n) {
            if (u == n) {
                res++;
            }
            return;
        }

        for (int i = 1; i <= 2; i++) {
            dfs(u + i);
        }
    }
}
