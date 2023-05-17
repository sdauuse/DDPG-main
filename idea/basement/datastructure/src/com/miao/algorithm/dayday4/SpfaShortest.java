package com.miao.algorithm.dayday4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SpfaShortest {
    static final int N = 100010;
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] h = new int[N];
    static int[] w = new int[N];
    static int[] dist = new int[N];

    static boolean[] visited = new boolean[N];
    static int idx = 0;
    static final int INF = 0x3f3f3f3f;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        Arrays.fill(w, 0, m + 1, INF);
        Arrays.fill(dist, 0, n + 1, INF);
        Arrays.fill(h, 0, n + 1, -1);
        Arrays.fill(ne, 0, m + 1, -1);

        for (int i = 0; i < m; i++) {
            String[] s1 = bf.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            int c = Integer.parseInt(s1[2]);
            add(a, b, c);
        }

        boolean flag = spfa(n);
        if (!flag){
            System.out.println("impossible");
        }else{
            System.out.println(dist[n]);
        }

    }

    private static boolean spfa(int n) {
        dist[1] = 0;
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            visited[poll] = false;

            for (int i = h[poll]; i != -1; i = ne[i]) {
                int nowEle = e[i];
                int nowW = w[i];
                if (dist[nowEle] > dist[poll] + nowW) {
                    dist[nowEle] = dist[poll] + nowW;
                    if (!visited[nowEle]) {
                        q.add(nowEle);
                        visited[nowEle] = true;
                    }
                }
            }

        }
        if (dist[n] == INF) {
            return false;
        }
        return true;
    }

    private static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }


}
