package com.miao.algorithm.acwingunit3;

import java.util.Scanner;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-01-19
 * @Copyright：
 */
public class ArrangeNumber {
    private static int N = 20;
    private static int[] path = new int[N];
    private static boolean[] visited = new boolean[N];
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dfs(0);
    }

    private static void dfs(int u) {

        if (u == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                path[u] = i;
                visited[i] = true;
                dfs(u + 1);
                visited[i] = false;
            }
        }

    }
}
