package com.miao.algorithm.xiaohongshu2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-04-12
 * @Copyright：
 */
public class Two3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int res = ops(n, x, a);
        System.out.println(res);
    }

    private static int ops(int n, int x, int[] a) {
        Arrays.sort(a);
        int sum = 0;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += a[i] / 2;
            count++;
            if (sum >= x) {
                return count;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            int tempSum = sum - a[i] / 2 + a[i];
            int tempCount = count - 1;
            if (tempSum >= x) {
                return tempCount;
            }
        }
        return -1;
    }
}
