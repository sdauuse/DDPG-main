package com.miao.algorithm.dayday2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StuFinger {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        char[] bin = sc.next().toCharArray();
        char[] san = sc.next().toCharArray();

        for (int i = 0; i < bin.length; i++) {
            bin[i] ^= 1;
            if (set.size() > 1 && bin[0] == '0') continue;
            set.add(toDec(bin, 2));
            bin[i] ^= 1;
        }

        for (int i = 0; i < san.length; i++) {
            char temp = san[i];
            for (char j = '0'; j <= '2'; j++) {
                if (j != temp) {
                    san[i] = j;
                    if (set.size() > 1 && san[0] == '0') continue;
                    int x = toDec(san, 3);
                    if (set.contains(x)) {
                        System.out.println(x);
                        return;
                    }
                }
            }
            san[i] = temp;
        }
    }

    //任意进制转为10进制
    public static int toDec(char[] x, int b) {
        int res = 0;
        for (int i = 0; i < x.length; i++) {
            res = res * b + (x[i] - '0');
        }
        return res;
    }
}
