package com.miao.algorithm.mihayou;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-17
 * @Copyright：
 */
public class Three {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] energy = new long[n];
        for (int i = 0; i < n; i++) {
            energy[i] = sc.nextLong();
        }

        Arrays.sort(energy);

        long count = 1;
        for (int i = 1; i < n - 1; i++) {
            if (energy[i - 1] < energy[i] && energy[i] < energy[i + 1]
                    || energy[i - 1] == energy[i] && energy[i] < energy[i + 1]
                    || energy[i - 1] < energy[i] && energy[i] == energy[i + 1]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
