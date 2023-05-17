package com.miao.algorithm.luogu.tidanmathproblem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        int a = 0xffff0000;
        int b = 0x0000ffff;
        long res = ((x & a) >> 16) ^ ((x & b) << 16);
        System.out.println(res);
    }
}
