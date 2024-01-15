package com.miao.algorithm.acwingunit1;

import java.util.Scanner;

public class TargetSum {
    public static int N = (int) (1e5 + 10);
    public static int[] a = new int[N];
    public static int[] b = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int j = 0; j < m; j++) {
            b[j] = sc.nextInt();
        }

        method(n, m, x);
    }

    private static void method(int n, int m, int x) {

        int l = 0;
        int r = m - 1;
        while (l < n && r >= 0) {
            int temp = a[l] + b[r];
            if (temp == x) {
                System.out.println(l + " " + r);
                return;
            } else if (temp > x) {
                r--;
            } else {
                l++;
            }
        }

    }
}
