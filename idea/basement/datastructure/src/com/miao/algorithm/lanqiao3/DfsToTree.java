package com.miao.algorithm.lanqiao3;

import java.util.Scanner;

public class DfsToTree {
    //存储无向图
    static final int N = 200010;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] next = new int[N];
    static boolean[] visited = new boolean[N];
    static int idx = 0;
    static int n = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            h[i] = -1;
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            //无向图，需要存两个方向
            add(a, b);
            add(b, a);
        }

        //因为是无向图，可以从任意一个几点开始搜索
        int ans = dfs(1);
        System.out.println(ans);
    }

    public static void add(int a, int b) {
        e[idx] = b;
        next[idx] = h[a];
        //找索引
        h[a] = idx++;
    }

    public static int dfs(int u) {
        visited[u] = true;
        int sum = 1;
        for (int i = h[u]; i != -1; i = next[i]) {
            int j = e[i];
            if (!visited[j]) {
                int sub = dfs(j);
                sum = sum + sub;
            }
        }
        return sum;
    }
}
