package com.miao.algorithm.repeat;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MiGong {
    static final int N = 110;
    static int[][] g = new int[N][N];
    static int[][] d = new int[N][N];
    //上 右 下 左
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = sc.nextInt();
                d[i][j] = -1;
            }
        }

        bfs();
    }

    private static void bfs() {
        d[0][0] = 0;
        Queue<PII> q = new LinkedList<>();
        q.add(new PII(0, 0));

        while (!q.isEmpty()) {
            PII pos = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = pos.x + dx[i];
                int y = pos.y + dy[i];

                // 三个个判断条件，如果下一步没有越界，下一步没有墙，且没有走过，就可以走
                if (x >= 0 && x < n && y >= 0 && y < m && g[x][y] == 0 && d[x][y] == -1) {
                    q.add(new PII(x, y));
                    d[x][y] = d[pos.x][pos.y] + 1;
                }
            }
        }

        System.out.println(d[n - 1][m - 1]);
    }

    static class PII {
        public int x;
        public int y;

        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
