package com.miao.algorithm.lanqiao4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxCommonPrime {
    public static void main(String[] args) throws IOException {
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            String[] s = bf.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int res = gcd(a, b);
            System.out.println(res);
        }

    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
