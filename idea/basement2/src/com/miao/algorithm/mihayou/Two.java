package com.miao.algorithm.mihayou;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-17
 * @Copyright：
 */
public class Two {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] a = new long[n];
        long[] b = new long[m];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        for (int j = 0; j < m; j++) {
            b[j] = sc.nextLong();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        long count = 0;

        for (long x1 : a) {
            for (long y1 : b) {
                for (long x2 : a) {
                    for (long y2 : b) {
                        if (x2<=x1 && y2<= y1){
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
