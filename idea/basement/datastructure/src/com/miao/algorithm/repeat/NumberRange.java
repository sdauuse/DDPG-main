package com.miao.algorithm.repeat;

import com.sun.org.apache.bcel.internal.generic.LLOAD;

import java.util.Scanner;

public class NumberRange {
    static final int N = 100010;
    static int[] a = new int[N];
    static int[] arr = new int[N];

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int q = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            //arr[i] = sc.nextInt();
        }

        numberRange(n, q);
    }

   /* public static void numberRange(int length, int m) {

        int mid = 0;
        for (int i = 0; i < m; i++) {
            int obj = sc.nextInt();
            int l = -1;
            int r = length;

            while (l + 1 != r) {
                mid = l + r >> 1;
                if (arr[mid] >= obj) {
                    r = mid;
                } else {
                    l = mid;
                }
            }

            if (obj != arr[r]) {
                System.out.println("-1 -1");
            } else {
                System.out.print(r + " ");
                int ll = -1, rr = length;
                while (ll + 1 != rr) {
                    mid = ll + rr >> 1;
                    if (arr[mid] <= obj) {
                        ll = mid;
                    } else {
                        rr = mid;
                    }
                }
                if (arr[ll] != obj) {
                    System.out.println(r);
                } else {
                    System.out.println(ll);
                }
            }
        }


    }*/

    private static void numberRange(int n, int q) {
        int mid = 0;
        for (int i = 0; i < q; i++) {
            int obj = sc.nextInt();

            int l = -1;
            int r = n;
            while (l + 1 != r) {
                mid = l + r >> 1;
                if (a[mid] >= obj) {
                    r = mid;
                } else {
                    l = mid;
                }
            }

            if (obj != a[r]) {
                System.out.println("-1 -1");
            } else {

                int ll = r - 1, rr = n;
                while (ll + 1 != rr) {
                    mid = ll + rr >> 1;
                    if (a[mid] <= obj) {
                        ll = mid;
                    } else {
                        rr = mid;
                    }
                }

                if (a[ll] != obj) {
                    System.out.println(r + " " + r);
                } else {
                    System.out.println(r + " " + ll);
                }
            }

        }
    }
}
