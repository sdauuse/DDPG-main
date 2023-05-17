package com.miao.algorithm.lanqiao;

import java.util.Scanner;

public class PreSum {
    static final int N = 100010;
    static int[] arr = new int[N];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        preSum(n, m);
    }

    public static void preSum(int length, int m) {
        int[] sum = new int[length + 1];
        int l;
        int r;

        for (int i = 1; i <= length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        for (int i = 0; i < m; i++) {
            l = sc.nextInt();
            r = sc.nextInt();

            System.out.println(sum[r] - sum[l - 1]);
        }
    }
}
