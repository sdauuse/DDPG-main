package com.miao.algorithm.lanqiao4;

import java.util.Scanner;

public class PermutationAndCombination {
    static final int N = 2010;
    static final int eps = (int) (1e9 + 7);
    static int[][] a = new int[N][N];

    public static void main(String[] args) {
        preOp();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a[c][b]);
        }
    }

    public static void preOp() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    a[i][j] = 1;
                } else {
                    a[i][j] = (a[i - 1][j] + a[i - 1][j - 1]) % eps;
                }

            }
        }
    }
}
