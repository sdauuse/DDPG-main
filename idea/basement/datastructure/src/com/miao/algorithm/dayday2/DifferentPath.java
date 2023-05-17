package com.miao.algorithm.dayday2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DifferentPath {
    static final int N = 8;
    static int[][] g = new int[N][N];
    static Set<Integer> set = new HashSet<>();
    //上 右 下 左
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static int n;
    static int m;
    static int k = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                g[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                dfs(i, j, 0, g[i][j]);
            }
        }

        System.out.println(set.size());
    }

    private static void dfs(int a, int b, int u, int num) {

        if (u == k) {
            set.add(num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];
            if (go(x, y)) {
                dfs(x, y, u + 1, num * 10 + g[x][y]);
            }
        }
    }

    public static boolean go(int x, int y) {

        if (x < 1 || x > n || y < 1 || y > m) {
            return false;
        }
        return true;
    }
}
