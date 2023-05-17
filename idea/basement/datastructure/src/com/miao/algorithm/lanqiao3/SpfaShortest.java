package com.miao.algorithm.lanqiao3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SpfaShortest {
    static final int N = 100010;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] w = new int[N];
    static int idx = 0;

    static int[] dist = new int[N];
    static boolean[] visited = new boolean[N];
    static final int INF = 0x3f3f3f3f;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Arrays.fill(h, -1);


        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            add(a, b, c);
        }

        spfa(n, m);
    }

    private static void spfa(int n, int m) {
        Arrays.fill(dist, INF);
        dist[1] = 0;
        visited[1] = true;

        queue.add(1);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = false;

            for (int i = h[cur]; i != -1; i = ne[i]) {
                int j = e[i];

                if (dist[j] > dist[cur] + w[i]) {
                    dist[j] = dist[cur] + w[i];

                    if (!visited[j]) {
                        queue.add(j);
                        visited[j] = true;
                    }
                }
            }
        }
        if (dist[n] == INF) {
            System.out.println("impossible");
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
