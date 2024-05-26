package com.miao.algorithm.bilibili;

import java.util.Scanner;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-04-20
 * @Copyright：
 */
public class One {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long res = count(n);
        System.out.println(res);
    }

    private static long count(long n) {
        long total = (n * n) - n;
        return total/2;
    }
}
