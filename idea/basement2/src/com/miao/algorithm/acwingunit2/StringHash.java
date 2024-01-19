package com.miao.algorithm.acwingunit2;

import java.util.Scanner;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-01-19
 * @Copyright：
 */
public class StringHash {
    public static int N = 100010;
    public static int P = 131;
    public static long q = (long) Math.pow(2, 64);
    public static long[] h = new long[N];
    public static long[] p = new long[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * P;
            h[i] = (h[i - 1] * P + s.charAt(i - 1)) % q;
        }

        for (int i = 0; i < m; i++) {
            int l1 = sc.nextInt();
            int r1 = sc.nextInt();
            int l2 = sc.nextInt();
            int r2 = sc.nextInt();
            if (get(l1, r1) == get(l2, r2)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static long get(int l, int r) {
        return h[r] - h[l - 1] * p[r - l + 1];
    }
}
