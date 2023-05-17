package com.miao.algorithm.lanqiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DoubleBinary {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        double n = Double.parseDouble(bf.readLine());
        binary(n);
    }

    public static void binary(double n) {
        double low = -10000;
        double high = 10000;
        double mid = 0;
        while (high - low >= 1e-8) {
            mid = (low + high) / 2;
            if (Math.pow(mid, 3) >= n) {
                high = mid;
            } else {
                low = mid;
            }

        }
        System.out.println(String.format("%.6f",mid));
    }
}
