package com.miao.algorithm.lanqiao3;

import java.util.Arrays;
import java.util.Scanner;

public class HungarianAlgorithm {
    static final int N = 510;
    static final int M = 100010;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static int idx = 0;
    // 右边的妹子对应的男生
    static int[] match = new int[N];
    // 记录妹子有无恋爱史
    static boolean[] st = new boolean[N];

    public static void main(String[] args) {
        Arrays.fill(h, -1);
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a, b);
        }

        int res = 0;
        for (int i = 1; i <= n1; i++) {
            Arrays.fill(st, false);
            if (find(i)) {
                res++;
            }
        }

        System.out.println(res);
    }

    private static boolean find(int x) {

        for (int i = h[x]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!st[j]) {
                st[j] = true;
                if (match[j] == 0 || find(match[j])) {
                    match[j] = x;
                    return true;
                }
            }
        }

        return false;
    }

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
