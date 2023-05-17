package com.miao.algorithm.suanfajinjiezhinan1;

import java.util.Arrays;
import java.util.Scanner;

public class StringSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = "WHERETHEREISAWILLTHEREISAWAY";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
    }
}
