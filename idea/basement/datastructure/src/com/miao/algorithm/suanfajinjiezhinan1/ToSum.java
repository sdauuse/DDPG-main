package com.miao.algorithm.suanfajinjiezhinan1;

import java.util.Scanner;

public class ToSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        long b = 0;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b += a[i];
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + a[i] * (b - a[i]);
            b = b - a[i];
        }

        System.out.println(sum);
    }
}
