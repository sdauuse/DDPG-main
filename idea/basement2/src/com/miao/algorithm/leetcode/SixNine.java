package com.miao.algorithm.leetcode;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-04-13
 * @Copyright：
 */
public class SixNine {
    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }

    public static int mySqrt(int x) {
        double l = -10000;
        double r = 10000;
        Double mid = null;

        while (r - l >= 1e-8) {
            mid = (l + r) / 2;
            if (mid * mid >= x) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return mid.intValue();
    }
}
