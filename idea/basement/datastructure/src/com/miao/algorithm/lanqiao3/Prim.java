package com.miao.algorithm.lanqiao3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prim {
    static final int N = 510;
    static int[] dist = new int[N];
    static int[][] g = new int[N][N];
    static boolean[] visited = new boolean[N];
    static int[] prev = new int[N];
    static final int MAX = 0x3f3f3f3f;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        for (int i = 1; i <= n; i++) {

            Arrays.fill(g[i], MAX);
        }

        for (int i = 0; i < m; i++) {
            String[] s1 = bf.readLine().split(" ");
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);
            int c = Integer.parseInt(s1[2]);
            g[x][y] = Math.min(g[x][y], c);
            g[y][x] = Math.min(g[y][x], c);
        }

        prim(n, m);
    }


    private static void prim(int n, int m) {
        Arrays.fill(dist, MAX);
        dist[1] = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {

            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }


            // 如果有孤立的点直接返回不存在最小生成树
            if (dist[t] == MAX) {
                System.out.println("impossible");
                return;
            }

            res += dist[t];

            visited[t] = true;

            //通过选好的点，去更新其他节点到 当前生成的树的最小距离
            for (int j = 1; j <= n; j++) {
                if (dist[j] > g[t][j] && !visited[j]) {
                    dist[j] = g[t][j];
                    prev[j] = t;
                }
            }

        }

        System.out.println(res);
    }
}