package com.miao.algorithm.lanqiao4;

import java.util.Scanner;

public class OLaFunction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            olaFunction(x);
        }
    }

    private static void olaFunction(int x) {
        long res = x;

        for (int i = 2; i <= x / i; i++) {


            if (x % i == 0) {
                res = res * (i - 1) / i;
            }

            while (x % i == 0) {
                x = x / i;
            }
        }

        if (x > 1) {
            res = res * (x - 1) / x;
        }

        System.out.println(res);
    }
}
