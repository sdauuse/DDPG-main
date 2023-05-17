package com.miao.algorithm.suanfajinjiezhinan1;

import java.util.Scanner;

public class TimeDisplay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long time = sc.nextLong();

        long day = 1000 * 60 * 60 * 24;
        long h = 1000 * 60 * 60;
        long m = 1000 * 60;
        long s = 1000;

        long n = time / day;
        time -= day * n;

        long hh = time / h;
        n = time / h;
        time -= h * n;
        long mm = time / m;
        n = time / m;
        time -= n * m;
        long ss = time / s;
        System.out.printf("%02d:%02d:%02d", hh, mm, ss);
    }
}
