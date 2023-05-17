package com.miao.algorithm.lanqiao2;

import java.util.Scanner;

@SuppressWarnings("all")
public class HashChars {
    static final int N = 100010;
    static final int P = 131;
    //存放hash前缀值得数组
    static long[] h = new long[N];
    //这是存放p的n次方的数组
    static long[] p = new long[N];
    static long mod = (long) Math.pow(2, 64);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();
        p[0] = 1;

        System.out.println(s.charAt(1));

        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * P;
            h[i] = (h[i - 1] * P + s.charAt(i - 1)) % mod;
            System.out.println((h[i - 1] * P + s.charAt(i - 1)) % mod);
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
        return h[r] - h[l - 1] * p[r - l + 1];
    }
}
