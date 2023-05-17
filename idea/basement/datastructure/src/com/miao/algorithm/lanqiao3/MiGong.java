package com.miao.algorithm.lanqiao3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

@SuppressWarnings("all")
public class MiGong {
    static Queue<PII> q = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    //n,m分别为图的行数和列数
    static int n = sc.nextInt();
    static int m = sc.nextInt();
    //用来存储迷宫地图
    static int[][] g = new int[n][m];
    //用来存储走的距离
    static int[][] d = new int[n][m];
    //上 右 下 左
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {

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
        q.add(new PII(0, 0));

        while (!q.isEmpty()) {
            PII now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m && g[nextX][nextY] != 1 && d[nextX][nextY] == -1) {
                    d[nextX][nextY] = d[now.x][now.y] + 1;
                    q.add(new PII(nextX, nextY));
                }
            }
        }

        System.out.println(d[n-1][m-1]);
    }


    private static class PII {
        int x, y;

        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
