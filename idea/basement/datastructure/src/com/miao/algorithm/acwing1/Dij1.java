package com.miao.algorithm.acwing1;

import java.util.Arrays;
import java.util.Scanner;

public class Dij1 {

    static int N = 510;
    static int INF = 0x3f3f3f3f;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] visited = new boolean[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Arrays.fill(dist, INF);
        for (int i = 0; i <= n; i++) {
            Arrays.fill(g[i], INF);
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            g[a][b] = Math.min(g[a][b], w);
        }

        dij(n, m);
    }

    private static void dij(int n, int m) {
        dist[1] = 0;

        for (int i = 0; i < n; i++) {

            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && (t == -1 || dist[t] + g[t][j] > dist[j])) {
                    t = j;
                }
            }

            visited[t] = true;

            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            }
        }

        if (dist[n] != INF) {
            System.out.println(dist[n]);
        } else {
            System.out.println(-1);
        }
    }
}
