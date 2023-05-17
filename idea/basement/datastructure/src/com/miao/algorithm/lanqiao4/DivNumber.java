package com.miao.algorithm.lanqiao4;

import java.util.Scanner;

public class DivNumber {
    static final int N = 20;
    static int[] p = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            p[i] = sc.nextInt();
        }

        int sum = 0;

        // 假设i = 4 =》 二进制表示 100 ，那么所对应的就是p3这种方案，就只选p3这一个集合
        for (int i = 1; i < 1 << m; i++) {
            // t代表当前所有质数的乘积，s代表什么当前选法包含几个集合
            long t = 1, s = 0;
            for (int j = 0; j < m; j++) {
                //这里是为了求出哪一位上是1，从而计算出1对应的位置的集合的交集数
                //比如i=5 =》二进制表示为101，表示方案p1和p3的交集， 那么下面(i>>j)&1==1 就是找到101的方案的值
                if ((i >> j & 1) == 1) {
                    if (t * p[j] > n) {
                        t = -1;
                        break;
                    }

                    t *= p[j];
                    s++;
                }
            }

            if (t != -1) {
                //s代表什么当前选法包含几个集合，s%2==0就表示有偶数个集合，结合容斥原理公式，应该为减法
                if (s % 2 != 0) {
                    sum += n / t;
                } else {
                    sum -= n / t;
                }
            }
        }

        System.out.println(sum);
    }
}
