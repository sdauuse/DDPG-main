package com.miao.algorithm.acwingunit1;

import java.util.Scanner;

public class FloatTwoDivide {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        double l = -10000;
        double r = 10000;
        double mid;
        while (r - l > 1e-8) {
            mid = (l + r) / 2;
            if (Math.pow(mid, 3) >= n) {
                r = mid;
            } else {
                l = mid;
            }
        }

        System.out.println(String.format("%.6f", r));
    }
}
