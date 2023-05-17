package com.miao.algorithm.lanqiao3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

@SuppressWarnings("all")
public class BFSToGraphSearch {
    static Queue<Integer> q = new LinkedList<>();
    static final int N = 100010;
    static int[] e = new int[N];
    static int[] h = new int[N];
    static int[] next = new int[N];
    static int[] d = new int[N];
    static int idx = 0;

    public static void main(String[] args) {
        // n个点，m条边
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            h[i] = -1;
            next[i] = -1;
            d[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a, b);
        }

        int res = bfs(n);
        System.out.println(res);
    }

    private static int bfs(int n) {
        q.add(1);
        d[1] = 0;

        while (!q.isEmpty()) {
            //取出队头
            int t = q.poll();
            for (int i = h[t]; i != -1; i = next[i]) {
                int s = e[i];
                if (d[s] == -1) {
                    d[s] = d[t] + 1;
                    q.add(s);
                }
            }
        }
        return d[n];
    }

    public static void add(int a, int b) {
        e[idx] = b;
        next[idx] = h[a];
        h[a] = idx++;
    }
}
