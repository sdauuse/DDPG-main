package com.miao.algorithm.lanqiao3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SpfaNegativeCircle {
    static final int N = 100010;
    static int[] dist = new int[N];
    static boolean[] visited = new boolean[N];
    static Queue<Integer> q = new LinkedList<>();
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] h = new int[N];
    static int[] w = new int[N];

    static int idx = 0;
    static final int INF = 0x3f3f3f3f;

    //判断是否有负环，保存从点1到达自己需要多少条边
    static int[] cnt = new int[N];

    public static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        Arrays.fill(h, -1);
        Arrays.fill(ne, -1);
        for (int i = 0; i < m; i++) {
            String[] s1 = bf.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            int c = Integer.parseInt(s1[2]);
            add(a, b, c);
        }

        boolean flag = spfa(n, m);

        if (flag){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    private static boolean spfa(int n, int m) {
        for (int i = 1; i <= n; i++) {
            q.add(i);
            visited[i] = true;
        }

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            visited[poll] = false;

            for (int i = h[poll]; i != -1; i = ne[i]) {
                int nowEle = e[i];
                int nowW = w[i];
                if (dist[nowEle] > dist[poll] + nowW) {
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
}
