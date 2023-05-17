package com.miao.algorithm.dayday2;

import java.util.Scanner;

public class StringPreHash {
    static final int N = 100010;
    static final int P = 131;
    static final int mod = (int) Math.pow(2, 64);
    static int[] p = new int[N];
    static int[] h = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();
        p[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            p[i] = p[i - 1] * P;
            h[i] = (h[i - 1] * P + s.charAt(i - 1)) % mod;
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


    public static long get(int l, int r) {
        return h[r] - p[r - l + 1] * h[l - 1];
    }
}
