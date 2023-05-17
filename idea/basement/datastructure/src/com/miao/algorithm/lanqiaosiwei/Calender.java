package com.miao.algorithm.lanqiaosiwei;

import java.util.Scanner;

public class Calender {
    static int[] days = new int[]{
            0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c;
        String[] s = sc.next().split("/");
        a = Integer.parseInt(s[0]);
        b = Integer.parseInt(s[1]);
        c = Integer.parseInt(s[2]);

        for (int i = 19600101; i <= 20591231; i++) {
            int year = i / 10000;
            int month = i % 10000 / 100;
            int day = i % 100;
            if (check(year, month, day)) {
                if (((year % 100) == a && month == b && day == c) || ((year % 100) == c && month == b && day == a) || ((year % 100) == c && month == a && day == b)) {
                    //不足两位时，在高位补0
                    System.out.printf("%d-%02d-%02d\n", year, month, day);
                }

            }
        }

    }

    public static boolean check(int year, int month, int day) {
        if (month > 12 || month <= 0 || day<=0) {
            return false;
        }

        if (month != 2 && day > days[month]) {
            return false;
        }

        if (month == 2) {
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                return day <= days[month] + 1;
            } else {
                return day <= days[month];
            }
        }


        return true;
    }
}
