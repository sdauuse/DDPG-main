package com.miao.algorithm.lanqiaosiwei;

import java.util.Scanner;

public class YangHui {
    static long n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        if (n == 1) {
            System.out.println(1);
            return;
        }

        for (int k = 16; k > 0; k--) {
            if (check(k)) {
                break;
            }
        }
    }

    private static boolean check(int k) {

        long l = 2 * k - 1, r = Math.max(n, 2 * k);
        while (l + 1 != r) {
            long mid = l + r >> 1;
            if (C2(mid, k) >= n) {
                r = mid;
            } else {
                l = mid;
            }
        }

        if (C2(r, k) != n) {
            return false;
        }

        long cl = (r + 1) * r / 2 + k + 1;
        System.out.println(cl);
        return true;
    }

    //递归计算组合太慢
   /* public static long C(int a, int b) {
        if (b == 1) {
            return a;
        } else if (b == 0) {
            return 1;
        } else if (a == 0) {
            return 0;
        } else {
            return C(a - 1, b) + C(a - 1, b - 1);
        }
    }*/

    public static long C2(long a, long b) {
        long res = 1;
        for (long i = a, j = 1; j <= b; i--, j++) {
            res = res * i / j;
            // 大于n已无意义，且防止爆long
            /*if (res > n) {
                return res;
            }*/
        }
        return res;
    }
}
