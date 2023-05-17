package com.miao.algorithm.dayday2;

import java.util.Scanner;

public class TreeTravel {
    static double x, y, c;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        x = sc.nextDouble();
        y = sc.nextDouble();
        c = sc.nextDouble();
        double l = 0;
        double r = Math.min(x, y);

        while (r - l > 1e-4) {
            double mid = (l + r) / 2;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }

        System.out.printf("%.3f\n",l);
    }

    public static boolean check(double s) {
        double rx = Math.sqrt(Math.pow(x, 2) - Math.pow(s, 2));
        double ry = Math.sqrt(Math.pow(y, 2) - Math.pow(s, 2));

        double sum = rx * ry / (rx + ry);
        if (sum < c) {
            return true;
        }
        return false;
    }
}
