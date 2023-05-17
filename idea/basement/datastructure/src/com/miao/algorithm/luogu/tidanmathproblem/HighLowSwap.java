package com.miao.algorithm.luogu.tidanmathproblem;

import java.util.Scanner;

public class HighLowSwap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        int[] a = getBinary(x);
        swap(a);
        toTen(2, a);
    }

    private static void toTen(int n, int[] a) {
        long res = 0;
        for (int i = 0; i <= 31; i++) {
            res = res * n + a[i];
        }

        System.out.println(res);
    }

    private static void swap(int[] a) {

        for (int i = 0; i <= 15; i++) {
            int j = i + 16;
            int temp = a[j];
            a[j] = a[i];
            a[i] = temp;
        }
    }

    private static int[] getBinary(long x) {
        int[] a = new int[32];
        int len = 31;
        while (x != 0) {
            if ((x & 1) == 1) {
                a[len] = 1;
            }
            len--;
            x = x >> 1;
        }
        return a;
    }
}
