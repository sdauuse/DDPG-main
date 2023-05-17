package com.miao.algorithm.lanqiao;

import java.util.Scanner;

public class CountBinaryOne {
    static final int N = 100010;
    static int[] arr = new int[N];
    static int[] length = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        countOne(n);
    }

    private static void countOne(int n) {

        for (int i = 0; i < n; i++) {
            int x = arr[i];
            while (x != 0) {
                x = x - lowBit(x);
                length[i]++;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(length[i] + " ");
        }
    }

    private static int lowBit(int x) {
        return x & -x;
    }
}
