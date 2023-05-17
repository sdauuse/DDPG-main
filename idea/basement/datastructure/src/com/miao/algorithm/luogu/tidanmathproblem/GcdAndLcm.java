package com.miao.algorithm.luogu.tidanmathproblem;

import java.util.Scanner;

public class GcdAndLcm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        //有一个公式， 最大公约数×最小公倍数=p*q;
        //因此 x*y = p*q;
        int sum = x * y;
        int max = Math.max(x, y);
        int res = 0;
        for (int q = Math.min(x, y); q <= max; q++) {
            if (sum % q == 0) {
                int p = sum / q;
                int g = gcd(p, q);
                int l = sum / g;
                if (g == x && l==y) {
                    res++;
                }
            }
        }

        System.out.println(res);
    }

    private static int gcd(int p, int q) {

        if (q == 0) {
            return p;
        } else {
            return gcd(q, p % q);
        }
    }
}
