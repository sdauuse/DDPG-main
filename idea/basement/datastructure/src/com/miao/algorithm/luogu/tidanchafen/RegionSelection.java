package com.miao.algorithm.luogu.tidanchafen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RegionSelection {
    static int N = 1050;
    static int[][] a = new int[N][N];
    static int[][] sum = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);

        for (int i = 1; i <= n; i++) {
            String[] s1 = bf.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                a[i][j] = Integer.parseInt(s1[j - 1]);
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + a[i][j];
            }
        }

        int max = Integer.MIN_VALUE;
        int rx = 0;
        int ry = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int startX = i;
                int startY = j;
                int endX = i + c - 1;
                int endY = j + c - 1;
                if (i + c - 1 <= n && j + c - 1 <= m) {
                    int temp = preSum(startX, startY, endX, endY);
                    if (temp > max) {
                        rx = startX;
                        ry = startY;
                        max = temp;
                    }
                }

            }
        }

        System.out.println(rx + " " + ry);
    }

    public static int preSum(int x1, int y1, int x2, int y2) {
        return sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1];
    }
}
