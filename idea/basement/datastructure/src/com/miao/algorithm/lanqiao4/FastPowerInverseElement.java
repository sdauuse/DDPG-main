package com.miao.algorithm.lanqiao4;

import java.util.Scanner;

public class FastPowerInverseElement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            long x = sc.nextInt();
            long p = sc.nextInt();

            if (x % p == 0) {
                System.out.println("impossible");
                continue;
            }
            Inverse(x, p);
        }
    }

    private static void Inverse(long x, long p) {
        long f = p - 2;

        long res = 1;
        while (f != 0) {
            if ((f & 1) == 1) {
                res = res * x % p;
            }

            x = x * x % p;
            f = f >> 1;
        }

        System.out.println(res);
    }
}
