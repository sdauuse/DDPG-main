package com.miao.algorithm.luogu.tidanmeiju;

import java.util.Scanner;

public class SelectionNumber {
    static int N = 30;
    static int[] a = new int[N];
    static int[] path = new int[N];
    static int n;
    static int m;
    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        dfs(0, 0);
        System.out.println(res);
    }

    //不减的深搜
    private static void dfs(int u, int start) {

        if (u >= m) {
            long sum = 0;
            for (int i = 0; i < m; i++) {
                sum += path[i];
            }

            if (check(sum)) {
                res++;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            path[u] = a[i];
            dfs(u + 1, i + 1);
        }

    }

    private static boolean check(long sum) {

        for (int i = 2; i <= sum / i; i++) {
            if (sum % i == 0) {
                return false;
            }
        }
        return true;
    }
}
