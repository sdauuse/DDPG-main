package com.miao.algorithm.luogu.tidanmeiju;

import java.util.Scanner;

public class Alien {
    static int N = 10010;
    static boolean[] visited = new boolean[N];
    static int[] a = new int[N];
    static int[] path = new int[N];
    static int n;
    static int m;
    static int idx = 0;
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        dfs(0);
    }

    private static void dfs(int u) {
        if (flag) {
            return;
        }
        if (u >= n) {
            idx++;
            if (idx == m + 1) {
                for (int i = 0; i < n; i++) {
                    System.out.print(path[i] + " ");
                }
                flag = true;
            }
            return;
        }

        for (int i = 1; i <= n; i++) {

            if (idx == 0) {
                i = a[u];
            }

            if (!visited[i]) {
                visited[i] = true;
                path[u] = i;
                dfs(u + 1);
                visited[i] = false;
            }
        }

    }
}
