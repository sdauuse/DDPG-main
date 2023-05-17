package com.miao.algorithm.luogu.tidanmeiju;

import java.util.Scanner;

public class FullPermutation {
    static int n;
    static byte[] visited;
    static int[] path;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new byte[n + 1];
        path = new int[n + 1];

        dfs(0);
    }

    private static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                System.out.printf("%5d", path[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {

            if (visited[i] == 0) {
                path[u] = i;
                visited[i] = 1;
                dfs(u + 1);
                visited[i] = 0;
            }

        }

    }
}
