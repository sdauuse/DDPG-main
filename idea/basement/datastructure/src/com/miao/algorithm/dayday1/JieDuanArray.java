package com.miao.algorithm.dayday1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JieDuanArray {

    static final int N = 100010;
    static int[] a = new int[N];
    static int[] s = new int[N];
    static int ave;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] s1 = bf.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(s1[i - 1]);
        }

        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + a[i];
        }

        ave = s[n] / 3;
        jieDuanArr(n);
    }

    private static void jieDuanArr(int n) {
        if (n < 3 || s[n] % 3 != 0) {
            System.out.println(0);
            return;
        }

        int index = 0;
        long count = 0;
        for (int i = 1; i < n; i++) {
            // 先定第二刀口
            if (s[i] == 2 * ave) {
                count = count + index;

            }
            if (s[i] == ave) {
                index++;
            }
        }

        System.out.println(count);
    }

    //暴力解超时了
  /*  private static void jieDuanArr(int n) {
        if (n < 3) {
            System.out.println(0);
            return;
        }

        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n ; j++) {
                if (s[i] == s[j] - s[i] && s[n] - s[j] == s[i]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }*/
}
