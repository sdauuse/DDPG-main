package com.miao.algorithm.lanqiao3;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {

    static final int N = 1010;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] visited = new boolean[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n ; i++) {

            Arrays.fill(g[i], 0x3f3f3f3f);
        }


        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            g[a][b] = Math.min(g[a][b], w);
        }

        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        int res = dijkstra(n);
        System.out.println(res);
    }

    private static int dijkstra(int n) {


        dist[1] = 0;
        //每次都能确定至少一个最优值
        for (int i = 0; i < n; i++) {

            //表示当前要访问的节点
            int t = -1;
            for (int j = 1; j <= n; j++) {
                //j这点没有确认为最优点，且j这一点到源点的距离比之前确定的点t要短
                if (!visited[j] && (t == -1 || dist[j] < dist[t])) {
                    t = j;
                }
            }

            visited[t] = true;

            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            }

        }

        if (dist[n] == Integer.MAX_VALUE) {
            return -1;
        }

        return dist[n];
    }
}
