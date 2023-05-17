package com.miao.algorithm.luogu.tidanmoni;

import java.util.Scanner;

public class PolynomialOutput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int num;
        StringBuffer sb = new StringBuffer();
        for (int i = n; i >= 0; i--) {
            num = sc.nextInt();

            if (num == 0) {
                continue;
            }
            //根据正负、是否为最高此项决定加号
            if (i != n && num > 0) {
                sb.append("+");
            }
            //输出系数（系数不为正负1或指数为0）
            if ((Math.abs(num) > 1) || i == 0) {
                sb.append(num);
            }
            //-1系数特判，常数项已特判
            if (num == -1 && i != 0) {
                sb.append("-");
            }
            //二次及以上输出指数
            if (i > 1) {
                sb.append("x^").append(i);
            }
            //一次项
            if (i == 1) {
                sb.append("x");
            }

        }


        System.out.println(sb);
    }
}
