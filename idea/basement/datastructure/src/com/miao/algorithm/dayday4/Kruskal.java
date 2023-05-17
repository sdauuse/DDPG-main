package com.miao.algorithm.dayday4;

import java.util.Arrays;
import java.util.Scanner;

public class Kruskal {
    static int N = 200010;
    static Edge[] edges = new Edge[N];
    static int[] p = new int[N];
    static int totalW = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i < n; i++) {
            p[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edges[i] = new Edge(a, b, c);
        }

        Arrays.sort(edges, 0, m);
        boolean flag = kruskal(n, m);

        if (flag) {
            System.out.println(totalW);
        } else {
            System.out.println("impossible");
        }
    }

    private static boolean kruskal(int n, int m) {
        int len = 0;
        for (int i = 0; i < m; i++) {
            int a = edges[i].a;
            int b = edges[i].b;
            int c = edges[i].w;
            int aF = find(a);
            int bF = find(b);
            if (aF != bF) {
                totalW += c;
                len++;
                p[aF] = bF;
            }
        }

        if (len == n - 1) {
            return true;
        }
        return false;
    }

    public static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return w - o.w;
        }
    }
}
