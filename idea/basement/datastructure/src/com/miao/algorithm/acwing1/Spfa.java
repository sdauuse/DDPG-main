package com.miao.algorithm.acwing1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Spfa {
    static int N = (int) (1e5 + 10);
    static int[] e = new int[N];
    static int[] h = new int[N];
    static int[] ne = new int[N];
    static int[] dist = new int[N];
    static int[] w = new int[N];
    static boolean[] visited = new boolean[N];
    static int idx = 0;
    static int INF = 0x3f3f3f3f;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {

        Arrays.fill(h, INF);
        Arrays.fill(dist, INF);
        Arrays.fill(ne, INF);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            add(a, b, c);
        }

        spfa(n, m);
    }

    private static void spfa(int n, int m) {
        q.add(1);
        dist[1] = 0;
        visited[1] = true;

        while (!q.isEmpty()) {
            int poll = q.poll();
            visited[poll] = false;
            for (int i = h[poll]; i != INF; i = ne[i]) {
                int nowEle = e[i];
                int nowW = w[i];
                if (dist[poll] + nowW < dist[nowEle]) {
                    dist[nowEle] = dist[poll] + nowW;
                    if (!visited[nowEle]) {
                        q.add(nowEle);
                        visited[nowEle] = true;
                    }
                }
            }
        }

        if (dist[n] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(dist[n]);
        }
    }

    public static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
