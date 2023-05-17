package com.miao.algorithm.lanqiao3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

@SuppressWarnings("all")
public class Kruskal {
    static final int N = 100010;
    static Edge[] edges;
    static int[] p = new int[N];
    //生成树树中边的数量
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        edges = new Edge[m];

        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }

        for (int i = 0; i < m; i++) {
            String[] s1 = bf.readLine().split(" ");
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);
            int c = Integer.parseInt(s1[2]);
            edges[i] = new Edge(x, y, c);
        }
        Arrays.sort(edges);
        kruskal(n, m);

    }

    private static void kruskal(int n, int m) {

        int res = 0;
        for (int i = 0; i < m; i++) {
            int fa = find(edges[i].x);
            int fb = find(edges[i].y);
            if (fa != fb) {
                p[fa] = fb;
                res += edges[i].c;
                count++;
            }
        }

        if (count == n - 1) {
            System.out.println(res);
        } else {
            System.out.println("impossible");
        }

    }


    static public int find(int a) {//并查集找祖宗
        if (p[a] != a) {
            p[a] = find(p[a]);
        }
        return p[a];
    }

    static class Edge implements Comparable<Edge> {
        int x;
        int y;
        int c;

        public Edge(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return c - o.c;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "x=" + x +
                    ", y=" + y +
                    ", c=" + c +
                    '}';
        }
    }

}
