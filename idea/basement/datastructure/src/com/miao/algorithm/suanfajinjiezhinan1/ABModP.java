package com.miao.algorithm.suanfajinjiezhinan1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ABModP {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        long a = Long.parseLong(s[0]);
        long b = Long.parseLong(s[1]);
        long p = Long.parseLong(s[2]);

        long res = 1;

        while (b != 0) {
            if ((b & 1) != 0) {
                res = res * a % p;
                b = b >> 1;
                a = a * a % p;
            }
        }

        System.out.println(res % p);
    }
}
