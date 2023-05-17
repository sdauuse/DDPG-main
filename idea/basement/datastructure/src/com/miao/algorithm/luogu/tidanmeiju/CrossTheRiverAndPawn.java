package com.miao.algorithm.luogu.tidanmeiju;

import java.util.Scanner;

public class CrossTheRiverAndPawn {
    static int N = 40;
    static long[][] g = new long[N][N];
    static long[][] dp = new long[N][N];

    // 左上左 左上上 右上上 右上右 右下右 右下下 左下下 左下左
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int n;
    static int m;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt() + 2;
        m = sc.nextInt() + 2;
        int mX = sc.nextInt() + 2;
        int mY = sc.nextInt() + 2;

        g[mX][mY] = 1;

        for (int i = 0; i < 8; i++) {
            int x = mX + dx[i];
            int y = mY + dy[i];
            g[x][y] = 1;
        }

        dp[2][1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                if (g[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        System.out.println(dp[n][m]);

    }

    private static boolean check(int x, int y) {

        if (x >= 1 && x <= n && y >= 1 && y <= m) {
            return true;
        }
        return false;
    }
}
