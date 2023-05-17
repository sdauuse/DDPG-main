package com.miao.algorithm.lanqiao4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNumber {
    static int count = 0;
    static final int N = 1000010;
    static boolean[] com = new boolean[N];
    static int[] pri = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int n = Integer.parseInt(s);

        isPrime(n);

        System.out.println(count);
    }

    //埃氏筛 O(nloglogn)
    private static void isPrime(int x) {

        for (int i = 2; i <= x; i++) {
            if (!com[i]) {
                pri[count++] = i;
                for (int j = i + i; j <= x; j = j + i) {
                    com[j] = true;
                }
            }
        }
    }


    /*暴力法，会超时
    private static void isPrime(int x) {

        if (x < 2) {
            return;
        }

        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) {
                return;
            }
        }
        count++;
    }*/
}
