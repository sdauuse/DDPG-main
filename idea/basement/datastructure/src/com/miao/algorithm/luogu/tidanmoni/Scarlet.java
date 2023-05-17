package com.miao.algorithm.luogu.tidanmoni;

import java.util.Scanner;

public class Scarlet {
    static int N = 510;
    static int[][] a = new int[N][N];
    //b为暂存矩阵
    static int[][] b = new int[N][N];
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = (i - 1) * n + j;
            }
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int r = sc.nextInt();
            int z = sc.nextInt();

            rotation(x, y, r, z);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotation(int x, int y, int r, int z) {
        int range = 2 * r + 1;
        int startX = Math.max(x - r, 1);
        int endX = Math.min(x + r, n);
        int startY = Math.max(y - r, 1);
        int endY = Math.min(y + r, n);
        //z==0顺时针
        if (z == 0) {
            for (int i = startX; i <= endX; i++) {
                for (int j = startY; j <= endY; j++) {
                    b[j - y + x][y - i + x] = a[i][j];
                }
            }
        } else {
            for (int i = startX; i <= endX; i++) {
                for (int j = startY; j <= endY; j++) {
                    b[x - j + y][y + i - x] = a[i][j];
                }
            }
        }

        toOri(x, y, r);
    }

    private static void toOri(int x, int y, int r) {

        for (int i = x - r; i <= x + r; i++) {
            for (int j = y - r; j <= y + r; j++) {
                a[i][j] = b[i][j];
            }
        }
    }
}
