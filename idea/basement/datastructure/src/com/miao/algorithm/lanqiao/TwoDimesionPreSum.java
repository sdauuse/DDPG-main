package com.miao.algorithm.lanqiao;

import java.util.Scanner;

public class TwoDimesionPreSum {

    static final int row = 1010;
    static final int col = 1010;
    static int[][] arr = new int[row][col];
    static int[][] sum = new int[row][col];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int m = sc.nextInt();
        int num = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        preSum(n, m, num);
    }

    public static void preSum(int n, int m, int num) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + arr[i][j];
            }
        }


        for (int i = 0; i < num; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int s = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
            System.out.println(s);
        }

    }
}
