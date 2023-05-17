package com.miao.algorithm.acwing1;

import java.math.BigInteger;
import java.util.Scanner;

public class IntegerMultiple64bit {

    public static void main(String[] args) {

        //方法一，使用高精度
        Scanner sc = new Scanner(System.in);
        /*BigInteger a = new BigInteger(sc.next());
        BigInteger b = new BigInteger(sc.next());
        BigInteger p = new BigInteger(sc.next());

        BigInteger sum = a.multiply(b).mod(p);
        System.out.println(sum);*/

        //方法二，位运算
        long a = sc.nextLong();
        long b = sc.nextLong();
        long p = sc.nextLong();
        quickMultiple(a, b, p);

    }

    private static void quickMultiple(long a, long b, long p) {
        long sum = 0;
        while (b != 0) {
            if ((b & 1) == 1) {
                sum = (sum + a) % p;
            }
            b >>= 1;
            a = 2 * a % p;
        }

        System.out.println(sum);
    }
}
