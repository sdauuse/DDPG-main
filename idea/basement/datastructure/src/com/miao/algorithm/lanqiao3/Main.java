package com.miao.algorithm.lanqiao3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static final int N = 20;
    static int[] path = new int[N];
    static boolean[] visited = new boolean[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

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
