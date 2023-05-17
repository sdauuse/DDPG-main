package com.miao.algorithm.luogu.tidanmoni;

import java.util.Scanner;

public class QuickMi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        int n = sc.nextInt();

        double v = myPow(x, n);
        System.out.println(v);
    }

    public static double myPow(double x, int b) {
        double ans = 1;

        long n=b;
        //负数的快速幂
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        while (n != 0) {
            if ((n & 1) == 1) {
                ans = ans * x;
            }

            n = n >> 1;
            x = x * x;
        }
        return ans;
    }
}
