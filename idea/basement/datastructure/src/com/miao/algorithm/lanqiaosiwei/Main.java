package com.miao.algorithm.lanqiaosiwei;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[100];
        a[0]=1;
        for (int i = 0; i < 10; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0 || j == i) {
                    a[j]=1;
                    System.out.print(a[j]+" ");
                }else {
                    a[j] = a[j] + a[j-1];
                    System.out.print(a[j]+" ");
                }

            }
            System.out.println();
        }
    }
}

