package com.miao.algorithm.dayday3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ShortestDis {

    static PriorityQueue<PII> heap = new PriorityQueue<>();
    static final int N = 100010;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] w = new int[N];
    static int[] dist = new int[N];
    static boolean[] shop = new boolean[N];
    static boolean[] visited = new boolean[N];
    static int idx = 0;
    static int INF = 0x3f3f3f3f;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        Arrays.fill(h, 0, n + 1, -1);
        Arrays.fill(ne, 0, 2 * m + 1, -1);
        Arrays.fill(dist, 0, n + 1, INF);
        Arrays.fill(w, 0, 2 * m + 1, INF);
        for (int i = 0; i < m; i++) {
            String[] s1 = bf.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            int c = Integer.parseInt(s1[2]);
            add(a, b, c);
            add(b, a, c);
        }
        int k = Integer.parseInt(bf.readLine());
        for (int i = 0; i < k; i++) {
            int index = Integer.parseInt(bf.readLine());
            shop[index] = true;
        }
        int q = Integer.parseInt(bf.readLine());
        for (int i = 0; i < q; i++) {
            int start = Integer.parseInt(bf.readLine());
            dij(start, n, m);
            int min = INF;
            for (int j = 1; j <= n; j++) {
                if (dist[j] < min && shop[j]) {
                    min = dist[j];
                }

            }
            if (min == INF) {
                System.out.println(0);
            } else {
                System.out.println(min);
            }

            Arrays.fill(visited, 0, n + 1, false);
            Arrays.fill(dist, 0, n + 1, INF);
        }
    }

    private static void dij(int start, int n, int m) {
        dist[start] = 0;

        //堆优化迪杰斯特拉
        heap.add(new PII(start, 0));

        while (!heap.isEmpty()) {

            PII poll = heap.poll();
            int ver = poll.ver;
            int distance = poll.distance;

            if (visited[ver]) {
                continue;
            }
            visited[ver] = true;

            for (int i = h[ver]; i != -1; i = ne[i]) {
                int nowNode = e[i];
                int nowW = w[i];
                if (dist[nowNode] > distance + nowW) {
                    dist[nowNode] = distance + nowW;
                    heap.add(new PII(nowNode, dist[nowNode]));
                }
            }

        }


        //原始迪杰斯特拉做法会超时
        /*for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && (t == -1 || dist[j] < dist[t])) {
                    t = j;
                }
            }

            visited[t] = true;

            for (int index = h[t]; index != -1; index = ne[index]) {
                int nowEle = e[index];
                int nowW = w[index];
                dist[nowEle] = Math.min(dist[nowEle], dist[t] + nowW);
            }
        }*/
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
        h[a] = idx++;
    }
}
