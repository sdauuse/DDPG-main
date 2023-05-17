package com.miao.algorithm.luogu.tidanmoni;

import java.math.BigInteger;
import java.util.Scanner;

public class MaxMultiple {
    static int N = 10010;
    static int[] used = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = n;
        for (int i = 2; i < n; i++) {
            k -= i;
            if (k < 0) {
                k += i;
                break;
            }
            used[i] = 1;
        }

        for (int i = 2; i < n; i++) {
            if (used[i] == 1) {
                if (used[i + k] == 0) {
                    used[i] = 0;
                    used[i + k] = 1;
                    break;
                }
            }
        }

        BigInteger sum = new BigInteger("1");
        for (int i = 2; i < n; i++) {
            if (used[i] == 1) {
                System.out.print(i + " ");
                sum = sum.multiply(BigInteger.valueOf(i));
            }
        }

        System.out.println("\n" + sum);
    }
}
