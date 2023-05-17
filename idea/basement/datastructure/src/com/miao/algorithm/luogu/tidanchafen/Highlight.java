package com.miao.algorithm.luogu.tidanchafen;

import java.util.*;
import java.io.*;
import java.math.*;


public class Highlight {
    static int N = (int) (1e5 + 10);
    static long[] a = new long[N];
    static int[] c = new int[N];
    static int[] pa = new int[N];
    static int[] pb = new int[N];
    static int[] pc = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= m; i++) {
            c[i] = sc.nextInt();
        }
        for (int i = 1; i < m; i++) {
            a[Math.min(c[i], c[i + 1])] += 1;
            a[Math.max(c[i], c[i + 1])] -= 1;
        }

        for (int i = 1; i < N; i++) {
            a[i] += a[i - 1] ;
        }

        long res = 0;
        for (int i = 1; i < n; i++) {
            pa[i] = sc.nextInt();
            pb[i] = sc.nextInt();
            pc[i] = sc.nextInt();
        }
        for(int i = 1; i <n; i++) {
            res += Math.min(a[i] * pa[i], a[i] * pb[i] + pc[i]);
        }

        System.out.println(res);
    }


}