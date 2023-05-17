package com.miao.algorithm.repeat;

import java.util.Scanner;

public class ArrangeNumber {
    static final int N = 10;
    static boolean[] visited = new boolean[N];
    static int[] path = new int[N];
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(0);
    }

    private static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(path[i] +" ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path[u] = i;
                dfs(u+1);
                visited[i] = false;
            }

        }

    }
}
