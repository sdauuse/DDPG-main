package com.miao.algorithm.dayday3;

import java.util.Arrays;
import java.util.Scanner;

public class Dij {
    static final int N = 510;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] visited = new boolean[N];
    static final int MAX = 0x3f3f3f3f;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Arrays.fill(dist, MAX);
        for (int i = 0; i <= n; i++) {
            Arrays.fill(g[i], MAX);
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            g[a][b] = Math.min(g[a][b], w);
        }

        int res = dijkstra(n);
        System.out.println(res);
    }

    private static int dijkstra(int n) {
        dist[1] = 0;

        for (int i = 0; i < n; i++) {

            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && (t == -1 || dist[j] < dist[t])) {
                    t = j;
                }
            }

            visited[t] = true;
            for (int j = 2; j <= n; j++) {
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            }
        }

        if (dist[n] == MAX) {
            return -1;
        }

        return dist[n];
    }
}
