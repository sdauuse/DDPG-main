package com.miao.algorithm.lanqiao;

import java.util.Scanner;

public class LongestNoRe {
    static int N = 100100;
    static int[] arr = new int[N];
    static int[] re = new int[N];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        longest(n);
    }

    private static void longest(int n) {
        int l = 0;
        int r = 0;
        int len = 0;
        for (; l < n; l++) {
            re[arr[l]] += 1;
            while (re[arr[l]] > 1) {
                re[arr[r]] -= 1;
                r++;
            }
            len = Math.max(len, l - r + 1);
        }

        System.out.println(len);
    }
}
