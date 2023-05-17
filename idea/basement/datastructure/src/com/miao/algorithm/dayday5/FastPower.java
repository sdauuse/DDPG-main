package com.miao.algorithm.dayday5;

import java.util.Scanner;

public class FastPower {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            long a = sc.nextInt();
            long b = sc.nextInt();
            long p = sc.nextInt();
            fastPower(a, b, p);
        }

    }

    private static void fastPower(long a, long b, long p) {
        long res = 1;
        while (b != 0) {
            if ((b & 1) == 1) {
                res = res * a % p;
            }
            a = a * a % p;
            b = b >> 1;
        }

        System.out.println(res);
    }
}
