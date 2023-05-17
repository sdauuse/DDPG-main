package com.miao.algorithm.luogu.tidanmathproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("all")
public class HankSon {
    static int N = 200000;
    static boolean[] com = new boolean[N];
    static int[] pri = new int[N];
    static int idx = 0;

    static long a0;
    static long a1;
    static long b0;
    static long b1;
    static List<PII> list = new ArrayList<>();
    static List<Long> back = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        primes(45000);
        for (int i = 0; i < n; i++) {
            list.clear();
            back.clear();
            a0 = sc.nextLong();
            a1 = sc.nextLong();
            b0 = sc.nextLong();
            b1 = sc.nextLong();

            factor();
        }

    }

    //方法二，用质数优化求约数的过程
    public static void factor() {
        int res = 0;
        long temp = b1;
        for (int i = 0; i < idx && pri[i] <= temp / pri[i]; i++) {
            if (temp % pri[i] == 0) {
                int s = 0;
                while (temp % pri[i] == 0) {
                    s++;
                    temp = temp / pri[i];
                }
                list.add(new PII(pri[i], s));
            }
        }
        if (temp > 1) {
            list.add(new PII(temp, 1));
        }

        dfs(0, 1);

        for (int i = 0; i < back.size(); i++) {
            long x = back.get(i);
            if (gcd(x, a0) == a1 && x * b0 == gcd(x, b0) * b1) {
                res++;
            }

        }
        System.out.println(res);
    }

    //求x的备选项，并存入back中
    private static void dfs(int u, long x) {
        if (u >= list.size()) {
            back.add(x);
            return;
        }

        for (int i = 0; i <= list.get(u).count; i++) {
            dfs(u + 1, x);
            x *= list.get(u).x;
        }
    }

    static class PII {
        long x;
        int count;

        public PII(long x, int count) {
            this.x = x;
            this.count = count;
        }
    }
    //方法一，暴力求解
    /*public static void factor() {
        int res = 0;
        List<Long> list = new ArrayList<>();
        for (long i = 1; i <= b1 / i; i++) {
            if (b1 % i == 0) {
                list.add(i);
                if (i * i != b1) {
                    list.add(b1 / i);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            long x = list.get(i);
            if (gcd(x, a0) == a1 && x * b0 == gcd(x, b0) * b1) {
                res++;
            }

        }
        System.out.println(res);
    }*/

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void primes(int n) {

        for (int i = 2; i <= n; i++) {
            if (!com[i]) {
                pri[idx++] = i;
            }

            for (int j = 0; pri[j] <= n / i; j++) {
                com[pri[j] * i] = true;
                if (i % pri[j] == 0) {
                    break;
                }
            }
        }
    }
}
