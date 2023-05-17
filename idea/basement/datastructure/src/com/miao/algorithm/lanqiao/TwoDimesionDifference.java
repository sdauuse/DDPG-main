package com.miao.algorithm.lanqiao;

import java.util.Scanner;

public class TwoDimesionDifference {
    static final int row = 1010;
    static final int col = 1010;
    static int[][] a = new int[row][col];
    static int[][] b = new int[row][col];

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        difference(n, m, q);
    }

/*    public static void difference(int n, int m, int q) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                insert(i, j, i, j, a[i][j]);
            }
        }

        for (int i = 0; i < q; i++) {
            int x1, y1, x2, y2, c;
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            c = sc.nextInt();
            insert(x1, y1, x2, y2, c);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1] + b[i][j];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void insert(int x1, int y1, int x2, int y2, int c) {
        b[x1][y1] += c;
        b[x2 + 1][y1] -= c;
        b[x1][y2 + 1] -= c;
        b[x2 + 1][y2 + 1] += c;
    }*/

    public static void difference(int n, int m, int q) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                insert(i, j, i, j, a[i][j]);
            }
        }

        while (q-- > 0) {
            int x1, y1, x2, y2, c;
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            c = sc.nextInt();
            insert(x1, y1, x2, y2, c);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1] + b[i][j];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(a[i][j] + " ");
            }
        }

    }

    public static void insert(int x1, int y1, int x2, int y2, int c) {
        b[x1][y1] += c;
        b[x1][y2 + 1] -= c;
        b[x2 + 1][y1] -= c;
        b[x2 + 1][y2 + 1] += c;
    }
}
