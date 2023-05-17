package com.miao.algorithm.luogu.tidanmeiju;

import java.util.Scanner;

public class StatisticalSquare {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long rectangle = 0;
        long square = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                rectangle += (long) i * j;
                square += Math.min(i, j);
            }
        }
        long rec = rectangle - square;
        System.out.println(square + " " + rec);
    }
}
