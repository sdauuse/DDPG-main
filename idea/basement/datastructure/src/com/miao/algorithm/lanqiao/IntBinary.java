package com.miao.algorithm.lanqiao;

import java.io.IOException;
import java.util.Scanner;

public class IntBinary {
    public static int[] arr = new int[100001];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        numberRange(m, n);
    }

    public static void numberRange(int m, int length) {

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


    }

}
