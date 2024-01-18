package com.miao.algorithm.acwingunit2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-01-18
 * @Copyright：
 */
public class QuickPower {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            String[] s = bf.readLine().split(" ");
            long a = Long.valueOf(s[0]);
            long k = Long.valueOf(s[1]);
            long p = Long.valueOf(s[2]);
            long res = quickMi(a, k, p);
            System.out.println(res);
        }

    }

    public static long quickMi(long a, long k, long p) {
        long res = 1;
        while (k != 0) {
            if ((k & 1) != 0) {
                res = res * a % p;
            }
            k >>= 1;
            a = a * a % p;
        }

        return res;
    }
}
