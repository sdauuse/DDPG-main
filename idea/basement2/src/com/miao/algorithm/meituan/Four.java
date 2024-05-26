package com.miao.algorithm.meituan;

import java.util.Scanner;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-09
 * @Copyright：
 */
public class Four {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long count = 0;
        int[][] factors = new int[n][2];
        for (int i = 0; i < n; i++) {
            int temp = arr[i];
            while (temp % 2 == 0) {
                factors[i][0]++;
                temp /= 2;
            }
            while (temp % 5 == 0) {
                factors[i][1]++;
                temp /= 5;
            }
        }

        int[] prefixTwo = new int[n+1];
        int[] prefixFive = new int[n+1];
        for (int i = 1; i <= n; i++) {
            prefixTwo[i] = prefixTwo[i-1]+factors[i-1][0];
            prefixFive[i] = prefixFive[i-1]+ factors[i-1][1];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int two = prefixTwo[n] - (prefixTwo[j+1]-prefixTwo[i]);
                int five = prefixFive[n] - (prefixFive[j+1] - prefixFive[i]);
                if (Math.min(two,five)>=k){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
