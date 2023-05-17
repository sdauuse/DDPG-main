package com.miao.algorithm.luogu.tidanmoni;

import java.util.Scanner;

public class RockPaperScissors {
    static int N = 210;
    static int[] a = new int[N];
    static int[] b = new int[N];
    static int[][] check = {
            {0, -1, 1, 1, -1},
            {1, 0, -1, 1, -1},
            {-1, 1, 0, -1, 1},
            {-1, -1, 1, 0, 1},
            {1, 1, -1, -1, 0}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int na = sc.nextInt();
        int nb = sc.nextInt();
        for (int i = 0; i < na; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < nb; i++) {
            b[i] = sc.nextInt();
        }

        int left = 0;
        int right = 0;
        int scoreA = 0;
        int scoreB = 0;

        for (int i = 0; i < n; i++) {

            int res = check[a[left]][b[right]];
            if (res == 1) {
                scoreA++;
            } else if (res == -1) {
                scoreB++;
            }

            left = (left + 1) % na;
            right = (right + 1) % nb;
        }

        System.out.println(scoreA + " " + scoreB);
    }
}
