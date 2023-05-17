package com.miao.algorithm.lanqiao3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopSort {
    static final int N = 100010;
    static int[] e = new int[N];
    static int[] next = new int[N];
    static int[] h = new int[N];
    static int[] rd = new int[N];
    static int idx = 0;
    static int count = 0; // 统计有多少个元素入队
    static Queue<Integer> q = new LinkedList();
    static Queue<Integer> ans = new LinkedList();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n个点 m条边
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            next[i] = -1;
            rd[i] = 0;
            h[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a, b);
        }

        boolean res = topSort(n);

        if (!res) {
            System.out.println("-1");
        } else {
            int size = ans.size();
            for (int i = 0; i < size; i++) {
                System.out.print(ans.poll() + " ");
            }
        }
    }

    private static boolean topSort(int n) {
        for (int i = 1; i <= n; i++) {
            if (rd[i] == 0) {
                q.add(i);
                count++;
            }
        }

        if (q.isEmpty()) {
            return false;
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            ans.add(now);
            for (int i = h[now]; i != -1; i = next[i]) {
                int x = e[i];
                rd[x]--;
                if (rd[x] == 0) {
                    q.add(x);
                    count++;
                }
            }

        }

        return count == n;
    }

    public static void add(int a, int b) {
        e[idx] = b;
        next[idx] = h[a];
        h[a] = idx++;
        rd[b]++;
    }
}
