package com.miao.algorithm.lanqiao5;

import java.util.Arrays;
import java.util.Scanner;

public class NumberTriangle {
    static final int N = 510;
    static int INF = 0x3f3f3f3f;
    static int[][] dp = new int[N][N];
    static int[][] a = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        //因为有负数，所以应该将两边也设为-INF
        for(int i=1;i<=n;i++){
            for(int j=0;j<=i+1;j++){
                dp[i][j]=-INF;
            }
        }
        dp[1][1]=a[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + a[i][j], dp[i - 1][j] + a[i][j]);
            }
        }

        //想一想，答案一定在最后一行
        int max = -INF;
        for (int i = 1; i <= n; i++) {
            max = Math.max(dp[n][i], max);
        }
        System.out.println(max);
    }
}
