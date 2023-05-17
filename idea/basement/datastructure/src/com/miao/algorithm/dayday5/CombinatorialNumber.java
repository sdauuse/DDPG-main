package com.miao.algorithm.dayday5;

import java.util.Scanner;

public class CombinatorialNumber {
    static final int N = 2010;
    static final int MOD = (int) (1e9 + 7);
    static int[][] C = new int[N][N];

    public static void main(String[] args) {

        preOps();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(C[a][b]);
        }
    }

    private static void preOps() {

        //C_i^j = C_{i-1}^j + C_{i-1}^{j-1}
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    C[i][j] = 1;
                } else {
                    C[i][j] = (C[i - 1][j] + C[i - 1][j - 1]) % MOD;
                }
            }
        }

    }
}
