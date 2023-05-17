package com.miao.algorithm.luogu.tidanmoni;

import java.math.BigInteger;
import java.util.Scanner;

public class Hierarchy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int obj = sc.nextInt();
            BigInteger res = new BigInteger(String.valueOf("1"));

            for (int j = 2; j <= x; j++) {
                res = res.multiply(new BigInteger(String.valueOf(j)));
            }

            String s = res.toString();
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (Integer.parseInt(s.substring(j, j + 1)) == obj) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }

}
