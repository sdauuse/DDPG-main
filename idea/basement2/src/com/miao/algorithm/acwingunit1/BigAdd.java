package com.miao.algorithm.acwingunit1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class BigAdd {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BigInteger a = new BigInteger(bf.readLine());
        BigInteger b = new BigInteger(bf.readLine());

        //加法
        //System.out.println(a.add(b));
        //减法
        //System.out.println(a.subtract(b));
        //乘法
        //System.out.println(a.multiply(b));
        //除法和余数
        System.out.println(a.divide(b));
        System.out.println(a.mod(b));
    }
}
