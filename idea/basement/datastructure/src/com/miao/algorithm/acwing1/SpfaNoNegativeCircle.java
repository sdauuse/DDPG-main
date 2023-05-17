package com.miao.algorithm.acwing1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SpfaNoNegativeCircle {
    static int N = 10010;
    static int[] e = new int[N];
    static int[] h = new int[N];
    static int[] w = new int[N];
    static int[] ne = new int[N];
    static boolean[] visited = new boolean[N];

    static int[] dist = new int[N];
    static int[] cnt = new int[N];
    static int idx = 0;
    static int INF = 0x3f3f3f3f;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Arrays.fill(ne, INF);
        Arrays.fill(h, INF);
        Arrays.fill(dist, INF);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            add(a, b, c);
        }

        boolean flag = spfa(n, m);

        if (flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean spfa(int n, int m) {
        for (int i = 1; i <= n; i++) {
            q.add(i);
            visited[i] = true;
        }

        while (!q.isEmpty()) {
            int poll = q.poll();
            visited[poll] = false;

            for (int i = h[poll]; i != INF; i = ne[i]) {
                int nowEle = e[i];
                int nowW = w[i];
                if (dist[poll] + nowW < dist[nowEle]) {
                    dist[nowEle] = dist[poll] + nowW;
                    cnt[nowEle] = cnt[poll] + 1;

                    if (cnt[nowEle] >= n) {
                        return true;
                    }

                    if (!visited[nowEle]) {
                        q.add(nowEle);
                        visited[nowEle] = true;
                    }
                }
            }
        }

        return false;
    }


    public static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
