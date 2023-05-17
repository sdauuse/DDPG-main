package com.miao.algorithm.luogu.tidanmathproblem;

import java.util.Arrays;
import java.util.Scanner;

public class Numbers {
    static int mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] maxNumbers = new int[n];

        for (int i = 0; i < n; i++) {
            maxNumbers[i] = sc.nextInt();
        }

        Arrays.sort(maxNumbers);
        long res = 1;
        for (int i = 0; i < n; i++) {
            res = res * (maxNumbers[i] - i) % mod;
        }

        System.out.println(res);
    }
}
