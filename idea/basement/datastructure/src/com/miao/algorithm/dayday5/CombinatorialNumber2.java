package com.miao.algorithm.dayday5;

import java.util.Scanner;

public class CombinatorialNumber2 {
    static final int N = 2010;
    static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(c(a, b));
        }
    }

    private static long c(int a, int b) {

        //分子
        long down = 1;
        for (int i = 1; i <= b; i++) {
            down = down * i;
        }
        //分母
        long up = 1;
        for (int i = a; i > a - b; i--) {
            up = up * i;
        }

        return (up / down) % MOD;
    }
}
