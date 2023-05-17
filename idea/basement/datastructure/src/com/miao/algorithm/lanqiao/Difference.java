package com.miao.algorithm.lanqiao;

import java.util.Scanner;

public class Difference {
    static final int N = 100010;
    static int[] a = new int[N];
    static int[] b = new int[N];

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int m = sc.nextInt();

        difference(n, m);
    }

    public static void difference(int n, int m) {
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            b[i] = a[i] - a[i - 1];
        }
        int l, r, c;

        for (int i = 0; i < m; i++) {
            l = sc.nextInt();
            r = sc.nextInt();
            c = sc.nextInt();
            b[l] = b[l] + c;
            b[r + 1] = b[r + 1] - c;
        }

        for (int i = 1; i <= n; i++) {
            a[i] = b[i] + a[i - 1];
            System.out.print(a[i] + " ");
        }

    }
}
