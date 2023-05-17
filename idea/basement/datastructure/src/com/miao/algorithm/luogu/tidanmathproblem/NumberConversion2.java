package com.miao.algorithm.luogu.tidanmathproblem;

import java.util.Scanner;

public class NumberConversion2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int m = sc.nextInt();

        toJinZhi(x, m);
    }

    private static void toJinZhi(int x, int m) {
        StringBuffer sb = new StringBuffer();
        int temp = x;
        while (x != 0) {
            int c = x % m;
            if (c < 0) {
                c -= m;
                x += m;
            }
            sb.append(toChar(c));
            x = x / m;
        }
        System.out.println(temp+"="+sb.reverse()+"(base" + m+")");
    }


    public static char toChar(int x) {
        if (x >= 10) {
            return (char) (x - 10 + 'A');
        }
        return (char) (x + '0');
    }
}
