package com.miao.algorithm.acwing1;

import java.util.Arrays;
import java.util.Scanner;

public class PowTravel {
    static int n;
    static boolean[] visited = new boolean[20];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dfs(1);
    }

    private static void dfs(int u) {

        if (u > n) {
            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            return;
        }

        visited[u] = true;
        dfs(u + 1);

        visited[u] = false;
        dfs(u + 1);
    }
}
