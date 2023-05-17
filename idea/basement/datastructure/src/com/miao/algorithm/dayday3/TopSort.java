package com.miao.algorithm.dayday3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopSort {
    static final int N = 100010;
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] h = new int[N];
    static int[] d = new int[N];
    static int idx = 0;

    static Queue<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Arrays.fill(h, -1);
        Arrays.fill(ne, -1);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a, b);
            d[b]++;
        }

        boolean flag = topSort(n, m);

        if (flag) {
            for (Integer integer : path) {
                System.out.print(integer + " ");
            }
        } else {
            System.out.println("-1");
        }
    }

    private static boolean topSort(int n, int m) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            path.add(now);
            for (int i = h[now]; i != -1; i = ne[i]) {
                int a = e[i];
                d[a]--;
                if (d[a] == 0) {
                    q.add(a);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (d[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
