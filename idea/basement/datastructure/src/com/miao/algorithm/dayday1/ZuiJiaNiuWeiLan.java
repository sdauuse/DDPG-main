package com.miao.algorithm.dayday1;

import java.util.Scanner;

public class ZuiJiaNiuWeiLan {
    static final int N = 100010;
    static int[] s = new int[N];
    static int[] a = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + a[i];
        }

        ops(n, f);
    }

    private static void ops(int n, int f) {

        long max = 0;
        for (int i = f; i <= n; i++) {
            if (max < s[i] - s[i - f]) {
                max = s[i] - s[i - f];
            }
        }

        max = (max * 1000 / f);
        System.out.println(max);
    }
}
