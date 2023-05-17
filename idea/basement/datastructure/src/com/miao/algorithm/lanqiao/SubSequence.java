package com.miao.algorithm.lanqiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SubSequence {
    static final int N = 100010;
    static int[] a = new int[N];
    static int[] b = new int[N];

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


        subSequence(n, m);
    }

    private static void subSequence(int n, int m) {
        int i = 0;
        int j = 0;
        for (; i < n && j < m; ) {
            if (b[j] == a[i]) {
                j++;
                i++;
            } else {
                j++;
            }
        }

        if (i == n) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
