package com.miao.algorithm.lanqiaosiwei;

import java.util.Scanner;

public class SaoLei {
    static final int N = 110;
    static int[][] g = new int[N][N];
    //左上 上 右上 右 右下 下 左下 左
    static int[] dx = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
    static int[][] bg = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                g[i][j] = sc.nextInt();
            }
        }


        ops(n, m);
    }

    private static void ops(int n, int m) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                bg[i][j] = check(i, j);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                System.out.print(bg[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int check(int x, int y) {
        int count = 0;
        if (g[x][y] == 1) {
            return 9;
        }

        for (int i = 0; i < 8; i++) {
            int a = x + dx[i];
            int b = y + dy[i];

            if (g[a][b] == 1) {
                count++;
            }
        }

        return count;
    }
}
