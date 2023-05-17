package com.miao.algorithm.acwing1;

public class BinaryOneNumber {
    public static int NumberOf1(int n) {
        int count = 0;

        while (n != 0) {
            n = n - lowBit(n);
            count++;
        }

        System.out.println(count);
        return count;
    }

    public static int lowBit(int x) {
        return x & -x;
    }

    public static void main(String[] args) {

        NumberOf1(-2);
    }
}
