package com.miao.algorithm.lanqiao4;

import java.util.Scanner;

public class NimGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int res = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            res = res ^ a;
        }

        if (res != 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
