package com.miao.algorithm.xiaohongshu;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-29
 * @Copyright：
 */
public class Three3 {
    private static final BigInteger mod = BigInteger.valueOf(1000000007);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < n; i++) {
            BigInteger likes = sc.nextBigInteger();
            sum = sum.add(likes);
        }

        if (sum.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            System.out.println(sum.mod(mod));
            return;
        }

        BigInteger expSum = (sum.multiply(BigInteger.valueOf(2))).mod(mod);
        System.out.println(expSum);
    }


}
