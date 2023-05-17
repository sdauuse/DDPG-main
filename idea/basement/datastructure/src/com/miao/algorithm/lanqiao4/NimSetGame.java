package com.miao.algorithm.lanqiao4;

import java.util.Scanner;

public class NimSetGame {
    static int N = 110,M = 10010,n,m;
    static int[] p = new int[M];//能够选择的每一次移动的数量
    static int[] f = new int[M];//每一个点的sg值
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            p[i] = sc.nextInt();
        }

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {

        }
    }
}
