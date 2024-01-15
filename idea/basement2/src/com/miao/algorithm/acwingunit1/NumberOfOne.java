package com.miao.algorithm.acwingunit1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfOne {
    public static int N = 100010;
    public static int[] a = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int n = Integer.parseInt(s);
        String[] s1 = bf.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s1[i]);
        }

        for (int i = 0; i < n; i++) {
            int count = 0;
            while (a[i] != 0) {
                a[i] = a[i] - lowBit(a[i]);
                count++;
            }
            System.out.print(count + " ");
        }

    }

    public static int lowBit(int a) {
        return a & (-a);
    }
}
