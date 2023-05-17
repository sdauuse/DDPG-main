package com.miao.algorithm.luogu.tidanchafen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalSum {

    static int N = 100010;
    static int mod = 10007;
    static int[] colors = new int[N];
    static int[] nums = new int[N];

    static int[] k1 = new int[N];


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String[] s1 = bf.readLine().split(" ");
        String[] s2 = bf.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(s1[i - 1]);
        }

        for (int i = 1; i <= n; i++) {
            colors[i] = Integer.parseInt(s2[i - 1]);
        }

        for (int i = 1; i <= n; i++) {

            //if ()

        }

    }
}
