package com.miao.algorithm.dayday3;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijHeap {

    static PriorityQueue<PII> heap = new PriorityQueue<>();
    static final int N = 150010;
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] h = new int[N];
    static int[] w = new int[N];
    static int idx = 0;
    static int[] dist = new int[N];
    static boolean[] visited = new boolean[N];

    static final int INF = 0x3f3f3f3f;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Arrays.fill(ne, 0, m + 1, -1);
        Arrays.fill(h, 0, n + 1, -1);
        Arrays.fill(w, 0, m + 1, INF);
        Arrays.fill(dist, 0, n + 1, INF);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            add(a, b, c);
        }

        dij(n, m);
    }

    private static void dij(int n, int m) {
        dist[1] = 0;
        heap.add(new PII(1, 0));

        while (!heap.isEmpty()) {
            PII poll = heap.poll();
            int ver = poll.ver;
            int dis = poll.distance;

            if (visited[ver]) {
                continue;
            }
            visited[ver] = true;
            //用ver更新其他点的距离
            for (int i = h[ver]; i != -1; i = ne[i]) {
                int nowNode = e[i];
                int nowW = w[i];
                if (dist[nowNode] > dis + nowW) {
                    dist[nowNode] = dis + nowW;
                    heap.add(new PII(nowNode, dist[nowNode]));
                }
            }

        }

        if (dist[n] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(dist[n]);
        }

    }

    static class PII implements Comparable<PII> {
        int ver;
        int distance;

        public PII(int ver, int distance) {
            this.ver = ver;
            this.distance = distance;
        }


        @Override
        public int compareTo(PII o) {
            return Integer.compare(distance, o.distance);
        }
    }

    public static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx ++;
    }
}
