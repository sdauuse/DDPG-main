package com.miao.algorithm.xiaohongshu;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-29
 * @Copyright：
 */
public class Three {
    public static final int mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] likes = new int[n];
        for (int i = 0; i < n; i++) {
            likes[i] = sc.nextInt();
        }

        long res = solve(n, likes);
        System.out.println(res);
    }

    private static long solve(int n, int[] likes) {
        long totalLikes = Arrays.stream(likes).asLongStream().sum();
        long midSteps = 0;
        for (int like : likes) {
            midSteps += (like + 1) / 2;
        }
        long oddCnt = 0;
        for (int like : likes) {
            if (like % 2 == 1) {
                oddCnt++;
            }
        }

        long eventCnt = n - oddCnt;
        long eventExp = eventCnt * 2L * n % mod;
        long oddExp = (oddCnt * (n + 1L) % mod) * n % mod;
        long exp = (eventExp + oddExp) % mod;
        return (exp + totalLikes * n % mod) % mod;
    }


}
