package com.miao.algorithm.acwingunit1;

import java.util.Scanner;

public class TwoDimDifference {
    public static int N = 1010;
    public static int[][] arr = new int[N][N];
    public static int[][] dif = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int q = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        //通过arr数组，逆向初始化dif数组
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                insert(i, j, i, j, arr[i][j]);
            }
        }

        for (int i = 0; i < q; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int c = sc.nextInt();
            insert(x1, y1, x2, y2, c);
        }

        //arr数组就是dif数组的前缀和，通过前缀和公式重新计算arr数组
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] + dif[i][j];
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void insert(int x1, int y1, int x2, int y2, int c) {
        dif[x1][y1] += c;
        dif[x2 + 1][y1] -= c;
        dif[x1][y2 + 1] -= c;
        dif[x2 + 1][y2 + 1] += c;
    }
}
