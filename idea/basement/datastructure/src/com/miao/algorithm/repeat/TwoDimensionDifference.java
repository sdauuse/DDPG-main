package com.miao.algorithm.repeat;

import java.util.Scanner;

public class TwoDimensionDifference {
    static final int N = 1010;
    static int[][] a = new int[N][N];
    static int[][] b = new int[N][N];

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int f = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        twoDimDifference(n, m, f);
    }

    private static void twoDimDifference(int n, int m, int f) {

        //构建差分数组
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                insert(i, j, i, j, a[i][j]);
            }
        }

        for (int i = 0; i < f; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int c = sc.nextInt();
            insert(x1, y1, x2, y2, c);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1] + b[i][j];
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static void insert(int x1, int y1, int x2, int y2, int c) {
        b[x1][y1] += c;
        b[x1][y2 + 1] -= c;
        b[x2 + 1][y1] -= c;
        b[x2 + 1][y2 + 1] += c;
    }
}
