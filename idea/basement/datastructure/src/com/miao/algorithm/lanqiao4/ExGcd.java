package com.miao.algorithm.lanqiao4;

import java.util.Scanner;

public class ExGcd {
    static int[] x = new int[1];
    static int[] y = new int[1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            exGcd(a, b, x, y);
            System.out.println(x[0] + " " + y[0]);
        }
    }

    private static int exGcd(int a, int b, int[] x, int[] y) {

        if (b == 0) {
            x[0] = 1;
            y[0] = 0;
            return a;
        }
        int gcd;
        gcd = exGcd(b, a % b, y, x);
        y[0] -= (a / b) * x[0];
        return gcd;
    }
}
