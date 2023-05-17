package com.miao.algorithm.lanqiao4;

import java.util.Scanner;

public class DecomposingPrimeFactor {
    static final int N = 100010;
    static int[] a = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();

            decompose(x);
        }

    }

    private static void decompose(int x) {

        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) {
                int s = 0;
                while (x % i == 0) {
                    x = x / i;
                    s++;
                }
                System.out.println(i + " " + s);
            }
        }

        if (x > 1) {
            System.out.println(x + " " + 1);
        }

        System.out.println();
    }
}
