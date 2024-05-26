package com.miao.algorithm.meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-09
 * @Copyright：
 */
public class Two {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = bf.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int q = Integer.parseInt(s1[1]);
        long[] arr = new long[n + 10];
        int unCount = 0;
        long knowCount = 0;
        String[] s = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
            if (arr[i] == 0) {
                unCount++;
            } else {
                knowCount += arr[i];
            }
        }

        for (int i = 0; i < q; i++) {
            String[] s2 = bf.readLine().split(" ");
            long l = Long.parseLong(s2[0]);
            long r = Long.parseLong(s2[1]);
            long minSum = knowCount + l * unCount;
            long maxSum = knowCount + r * unCount;
            System.out.println(minSum +" "+ maxSum);

        }
    }
}
