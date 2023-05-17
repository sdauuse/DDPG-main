package com.miao.algorithm.repeat;

import java.util.Scanner;

public class Difference {
    static final int N = 1000010;
    static int[] a = new int[N];
    static int[] b = new int[N];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            b[i] = a[i] - a[i - 1];
        }

        difference(n, m);
    }

    private static void difference(int n, int m) {
        for (int i = 0; i < m; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            int score = sc.nextInt();

            b[left] += score;
            b[right + 1] -= score;
        }


        for (int i = 1; i <= n; i++) {
            a[i] = b[i] + a[i-1];
            System.out.print(a[i]+" ");
        }
    }
}
