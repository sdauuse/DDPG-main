package com.miao.algorithm.lanqiaosiwei;

import java.util.Scanner;

public class TimeDisplay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long nowTime = sc.nextLong();

        long day = 1000 * 60 * 60 * 24;

        long n = nowTime / day;
        /*while (nowTime - day > 0) {
            nowTime = nowTime - day * n;
            n = nowTime/day;
        }*/
        nowTime = nowTime -day*n;

        long hh = 1000 * 60 * 60;
        long mm = 1000 * 60;
        long ss = 1000;

        long h = nowTime / hh;
        nowTime = nowTime - h * hh;
        long m = nowTime / mm;
        nowTime = nowTime - m * mm;

        long s = nowTime / ss;
        System.out.printf("%02d:%02d:%02d", h, m, s);
    }
}
