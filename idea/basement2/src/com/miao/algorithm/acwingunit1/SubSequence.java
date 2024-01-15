package com.miao.algorithm.acwingunit1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SubSequence {
    public static int N = (int) (1e5 + 10);
    public static int[] a = new int[N];
    public static int[] b = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        String[] s1 = bf.readLine().split(" ");
        String[] s2 = bf.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s1[i]);
        }
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(s2[i]);
        }

        twoPoint(n, m);
    }

    private static void twoPoint(int n, int m) {

        int l = 0;
        int r = 0;
        while (l < n && r < m) {

            if (a[l] == b[r]) {
                l++;
            }
            r++;
        }

        if (l >= n) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
