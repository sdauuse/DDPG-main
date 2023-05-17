package com.miao.algorithm.dayday5;

import java.util.Scanner;

public class SelectPrime {
    static final int N = (int) (1e6 + 10);
    static boolean[] com = new boolean[N];
    static int[] pri = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        countPrime(n);
    }

    private static void countPrime(int n) {
        int count = 0;

        for (int i = 2; i <= n; i++) {

            if (!com[i]) {
                //记录哪些数是质数
                pri[count++] = i;
                for (int j = i + i; j <= n; j = j + i) {
                    com[j] = true;
                }
            }
        }

        System.out.println(count);
    }
}
