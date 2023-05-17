package com.miao.algorithm.lanqiao4;

import java.util.Scanner;

public class ZhiShu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            boolean b = isPrime(x);
            if (b) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

    }

    private static boolean isPrime(int x) {

        if (x == 1) {
            return false;
        }

        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }
}
