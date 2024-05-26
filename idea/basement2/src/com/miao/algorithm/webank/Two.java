package com.miao.algorithm.webank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-31
 * @Copyright：
 */
public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        Arrays.sort(prices);
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int budget = sc.nextInt();
            int res = find(prices, budget);
            System.out.println(res);
        }
    }

    private static int find(int[] prices, int budget) {
        int left = 0;
        int right = prices.length - 1;
        while (left <= right) {
            int mid = left + (right - left) /2;
            if (prices[mid] <= budget) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
