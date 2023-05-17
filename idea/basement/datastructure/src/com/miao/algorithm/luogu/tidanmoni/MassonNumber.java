package com.miao.algorithm.luogu.tidanmoni;

import java.math.BigInteger;
import java.util.Scanner;

public class MassonNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        BigInteger two;
        two = quickMi(n);
        two = two.subtract(BigInteger.valueOf(1));

        int len = two.toString().length();
        System.out.println(len);

        if (len < 500) {
            int a = 500 - len;
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < a; i++) {
                s.append("0");
            }
            s.append(two);
            System.out.println(s.length());
            for (int i = 0; i < 10; i++) {
                System.out.println(s.substring(i * 50, (i + 1) * 50));
            }
        } else {
            for (int i = 0; i < 10; i++) {
                System.out.println(two.toString().substring(len - 500 + i * 50, len - 500 + (i + 1) * 50));
            }
        }
    }

    public static BigInteger quickMi(int n) {
        BigInteger ans = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        while (n != 0) {
            if ((n & 1) == 1) {
                ans = ans.multiply(two);
            }

            two = two.multiply(two);
            n = n >> 1;
        }

        return ans;
    }
}
