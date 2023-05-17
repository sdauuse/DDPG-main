package com.miao.algorithm.luogu.tidanmathproblem;

import java.util.Scanner;

public class Running {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long l = lcm(a, b);
        long res = lcm(c, l);
        System.out.println(res);
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static long lcm(long a, long b) {
        long sum = a * b;
        return sum / gcd(a, b);
    }
}
