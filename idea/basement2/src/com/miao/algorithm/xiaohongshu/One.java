package com.miao.algorithm.xiaohongshu;

import java.util.Scanner;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-29
 * @Copyright：
 */
public class One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double res = (2.0 / n) * (1.0 / (n - 1));

        System.out.printf("%.10f", res);
    }

}
