package com.miao.algorithm.xiaohongshu2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-04-12
 * @Copyright：
 */
public class Two2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = bf.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int x = Integer.parseInt(line1[1]);
        int[] a = new int[n];
        String[] line2 = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(line2[i]);
        }
        Arrays.sort(a);
        int count = 0;
        int total = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (total + a[i] >= x) {
                count++;
                System.out.println(count);
                break;
            }
            total += a[i] / 2;
            count++;
            if (total >= x) {
                System.out.println(count);
                break;
            }
        }


        if (total < x) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}
