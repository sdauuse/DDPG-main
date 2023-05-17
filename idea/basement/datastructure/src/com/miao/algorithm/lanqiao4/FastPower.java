package com.miao.algorithm.lanqiao4;

import java.util.Scanner;

public class FastPower {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            long a = sc.nextInt();
            long b = sc.nextInt();
            long mod = sc.nextInt();
            fastPower(a, b, mod);
        }
    }

    private static void fastPower(long a, long b, long mod) {

        long res = 1;
        while (b != 0) {

            if ((b & 1) == 1) {
                res = res * a % mod;
            }
            a = a * a % mod;
            b = b >> 1;
        }

        System.out.println(res);
    }
}
