package com.miao.algorithm.dayday1;

import java.util.Scanner;

public class ChangeArrElement {
    static final int N = 200010;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int[] a = new int[N];
            int[] b = new int[N];

            int m = sc.nextInt();
            for (int j = 1; j <= m; j++) {
                int x = sc.nextInt();

                x = Math.min(x,j);
                b[j - x + 1] += 1;
                b[j + 1] -= 1;
                //可优化下面代码
                /* if (x > j) {
                    b[1] += 1;
                    b[j + 1] -= 1;
                    continue;
                } else if (x == 0) {
                    continue;
                } else {
                    b[j - x + 1] += 1;
                    b[j + 1] -= 1;
                }*/
            }

            for (int j = 1; j <= m; j++) {
                a[j] = b[j] + a[j - 1];
                if (a[j] > 0) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
                System.out.println();
            }

        }
    }
}
