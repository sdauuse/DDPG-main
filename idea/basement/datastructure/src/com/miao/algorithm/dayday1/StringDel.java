package com.miao.algorithm.dayday1;

import java.util.Scanner;

public class StringDel {

    static final int N = 110;
    static int[] a = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String s = sc.next();

        for (int i = 0; i < n; i++) {
            a[i] = s.charAt(i);
        }

        int left = 0;
        int right = left + 1;
        int res = 0;
        while (left < n) {
            int count = 1;

            while ( a[left] == 'x' && a[right] == a[left]  && right < n) {
                count++;
                right++;
                if (count >= 3) {
                    res++;
                }
            }
            left = right;
            right = left + 1;
        }

        System.out.println(res);
    }
}
