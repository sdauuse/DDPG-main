package com.miao.algorithm.lanqiao2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UnionFind {

    static final int N = 100010;
    static int[] p = new int[N];

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }


        complete(m);
    }

    private static void complete(int m) throws IOException {

        for (int i = 0; i < m; i++) {
            String[] s = bf.readLine().split(" ");
            String query = s[0];
            int a = Integer.parseInt(s[1]);
            int b = Integer.parseInt(s[2]);

            if ("M".equals(query)) {
                if (a == b) {
                    continue;
                }
                p[find(b)] = find(a);

            } else if ("Q".equals(query)) {
                int p1 = find(a);
                int p2 = find(b);

                if (p1 == p2) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }

    public static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }

        return p[x];
    }

}
