package com.miao.algorithm.luogu.tidanmeiju;

import java.util.Scanner;

public class CombinedOutput {

    static int N = 30;
    static int n;
    static int m;
    static int[] path = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        dfs(0, 1);
    }

    private static void dfs(int u, int start) {

        if (u >= m) {
            for (int i = 0; i < m; i++) {
                //此题需要进行格式化
                System.out.printf("%3d",path[i]);
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {

            path[u] = i;
            dfs(u + 1, i + 1);
        }
    }
}
