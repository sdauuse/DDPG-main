package com.miao.algorithm.dayday5;

import java.util.Scanner;

public class PrimeProblem {
    static final int N = 1010;
    static boolean[] com = new boolean[N];
    static int[] pri = new int[N];
    static int cnt = 0;

    public static void main(String[] args) {
        preOp();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int res = 0;
            int n = sc.nextInt();
            int k = sc.nextInt();

            for (int j = 2; j <= n; j++) {
                if (!com[j]) {
                    for (int x = 1; x < cnt; x++) {
                        if (pri[x] + pri[x - 1] + 1 == j) {
                            res++;
                            break;
                        }
                    }
                }
            }

            if (res >= k) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void preOp() {

        for (int i = 2; i < N; i++) {
            if (!com[i]) {
                pri[cnt++] = i;
                for (int j = i + i; j < N; j = j + i) {
                    com[j] = true;
                }
            }
        }
    }
}
