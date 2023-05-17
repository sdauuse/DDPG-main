package com.miao.algorithm.dayday6;

import java.util.Scanner;

public class IntegerDiv {

    static final int N = 1000010;
    static long[] dp = new long[N];
    static final int mod = (int) 1e9;
    static long[] v = new long[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        init();

        dp[0] = 1;   //初始化
        for(int i = 0;i <= 20;++i){
            for(int j = (int) v[i]; j <= n; ++j){
                dp[j] = (dp[j] + dp[(int) (j - v[i])]) % mod;  //状态转移方程
            }
        }

        System.out.println(dp[n]);
    }

    //预处理出 2 的 0 次幂到 20 次幂
    public static void init() {
        v[0] = 1;
        for (int i = 1; i <= 20; i++) {
            v[i] = v[i - 1] * 2;
        }
    }

}
