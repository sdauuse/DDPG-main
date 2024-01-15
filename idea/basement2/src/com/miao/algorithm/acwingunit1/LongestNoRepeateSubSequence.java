package com.miao.algorithm.acwingunit1;

import java.util.Arrays;
import java.util.Scanner;

public class LongestNoRepeateSubSequence {
    public static int N = (int) (1e5 + 10);
    public static int[] arr = new int[N];
    public static int[] flag = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        int l = 1;
        int r = 1;
        int res = 0;

        while (r <= n) {
            flag[arr[r]]++;
            while (flag[arr[r]] > 1) {
                flag[arr[l]]--;
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }

        System.out.println(res);
    }
}
