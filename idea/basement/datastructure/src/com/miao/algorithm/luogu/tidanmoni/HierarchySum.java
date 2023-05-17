package com.miao.algorithm.luogu.tidanmoni;

import java.math.BigInteger;
import java.util.Scanner;

public class HierarchySum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger sum = new BigInteger("1");

        for (int i = 2; i <= n; i++) {
            BigInteger x = hierarchy(i);
            sum = sum.add(x);
        }

        System.out.println(sum);
    }

    private static BigInteger hierarchy(int n) {
        BigInteger sum = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            BigInteger x = new BigInteger(String.valueOf(i));
            sum = sum.multiply(x);
        }

        return sum;
    }
}
