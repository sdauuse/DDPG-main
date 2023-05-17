package com.miao.algorithm.dayday2;

import java.util.*;

public class WeiBoTrans {
    static final int N = 1010;
    static int[] M = new int[N];
    static int[][] g = new int[N][N];
    static boolean[] visited = new boolean[N];
    static int n;
    static int l;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();


        for (int i = 1; i <= n; i++) {
            M[i] = sc.nextInt();
            for (int j = 0; j < M[i]; j++) {
                int x = sc.nextInt();
                g[x][i] = 1;
            }
        }

        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int res = dfs(x);
            System.out.println(res);
        }


    }

    private static int dfs(int start) {
        Arrays.fill(visited, false);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        int res = 0;
        for (int i = 0; i < l; i++) {
            int size = q.size();
            while (size-- > 0) {
                int t = q.poll();
                for (int j = 1; j <= n; j++) {
                    if (g[t][j] == 0 || visited[j]) {
                        continue;
                    }
                    visited[j] = true;
                    q.add(j);
                    res++;
                }
            }
        }

        return res;
    }
}
