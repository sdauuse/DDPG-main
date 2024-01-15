package com.miao.algorithm.acwingunit1;

import java.util.Scanner;

public class Difference {
    public static final int N = 100010;
    public static int[] arr = new int[N];
    public static int[] dif = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            dif[i] = arr[i] - arr[i - 1];
        }
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int c = sc.nextInt();
            differenceMethod(l, r, c);
        }

        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + dif[i];
            System.out.print(arr[i]+" ");
        }

    }

    private static void differenceMethod(int l, int r, int c) {
        dif[l] += c;
        dif[r + 1] -= c;
    }
}
