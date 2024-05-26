package com.miao.algorithm.xiaohongshu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-29
 * @Copyright：
 */
public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] followers = new int[n];
        for (int i = 0; i < n; i++) {
            followers[i] = sc.nextInt();
        }

        int res = solve(n, x, followers);
        System.out.println(res);
    }

    private static int solve(int n, int x, int[] followers) {
        int[] sorted = Arrays.copyOf(followers, n);
        Arrays.sort(sorted);

        int minTimes = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int times = 1;
            int totalFollowers = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (i == j) {
                    totalFollowers += sorted[j];
                } else {
                    totalFollowers += sorted[j] / 2;
                }

                if (totalFollowers >= x) {
                    minTimes = Math.min(minTimes, times);
                    break;
                }
                times++;
            }
        }

        return (minTimes == Integer.MAX_VALUE) ? -1 : minTimes;
    }

}
