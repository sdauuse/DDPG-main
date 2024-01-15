package com.miao.algorithm.acwingunit1;

import java.util.Scanner;

public class PreSum {
    public static int N = 100010;
    public static int[] arr = new int[N];
    public static int[] sum = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            sum[i] = sum[i - 1] + arr[i];
        }

        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int res = preSumMethod(l, r);
            System.out.println(res);
        }
    }

    private static int preSumMethod(int l, int r) {
        return sum[r] - sum[l - 1];
    }
}
