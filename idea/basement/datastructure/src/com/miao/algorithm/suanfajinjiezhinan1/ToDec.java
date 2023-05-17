package com.miao.algorithm.suanfajinjiezhinan1;

import java.util.Scanner;

public class ToDec {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        char[] chars = n.toCharArray();
        toDec(chars, 9);
    }

    private static void toDec(char[] n, int i) {
        int res = 0;

        for (int j = 0; j < n.length; j++) {
            res = res * i + (n[j] - '0');
        }

        System.out.println(res);
    }


}
