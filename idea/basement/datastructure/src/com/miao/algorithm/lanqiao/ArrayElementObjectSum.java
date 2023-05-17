package com.miao.algorithm.lanqiao;

import java.util.Scanner;

public class ArrayElementObjectSum {
    static final int N = 100010;
    static int[] a = new int[N];
    static int[] b = new int[N];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        sum(n, m, x);
    }

    private static void sum(int n, int m, int x) {

        int i = 0;
        int j = m - 1;
        int sum = 0;
        for (; i < n; i++) {
            sum = a[i] + b[j];
            if (sum==x){
                System.out.print(i + " " + j);
                return;
            }

            while (j > 0 && sum > x) {
                j--;
                sum = a[i] + b[j];
                if (sum == x) {
                    System.out.print(i + " " + j);
                    return;
                }
            }

        }
    }
}
