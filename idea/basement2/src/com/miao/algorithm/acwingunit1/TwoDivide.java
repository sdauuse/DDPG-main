package com.miao.algorithm.acwingunit1;

import java.util.Scanner;

public class TwoDivide {
    public static int N = 100010;
    public static int[] arr = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < q; i++) {
            int target = sc.nextInt();
            divide(target, n);
        }
    }

    private static void divide(int target, int len) {
        int l = -1;
        int r = len;
        int mid = 0;
        while (l + 1 != r) {
            mid = l + r >> 1;
            if (arr[mid] >= target) {
                r = mid;
            } else {
                l = mid;
            }
        }

        if (target != arr[r]) {
            System.out.println("-1 -1");
        } else {
            System.out.print(r + " ");
            int ll = -1;
            int rr = len;
            while (ll + 1 != rr) {
                mid = ll + rr >> 1;
                if (arr[mid] <= target) {
                    ll = mid;
                }else {
                    rr = mid;
                }
            }
            if (arr[ll] != target) {
                System.out.println(r);
            } else {
                System.out.println(ll);
            }
        }
    }
}
