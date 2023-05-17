package com.miao.algorithm.lanqiao2;

import java.util.Scanner;

public class UnionPointsNumber {
    static final int N = 100010;
    static int[] p = new int[N];
    static Scanner sc = new Scanner(System.in);
    static int[] size = new int[N];

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            p[i] = i;
            size[i] = 1;
        }

        op(m);
    }

    private static void op(int m) {
        for (int i = 0; i < m; i++) {

            String query = sc.next();

            if (query.equals("C")) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (find(a) != find(b)) {
                    size[find(b)] += size[find(a)];
                    p[find(a)] = find(b);
                }

            } else if (query.equals("Q1")) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (find(a) == find(b)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }

            } else if (query.equals("Q2")) {
                int a = sc.nextInt();
                System.out.println(size[find(a)]);
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
