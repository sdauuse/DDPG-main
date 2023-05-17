package com.miao.algorithm.luogu.tidanmathproblem;

import java.util.Scanner;

public class NumberConversion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] s = sc.next().toCharArray();
        int m = sc.nextInt();

        int res = toTen(n, s);
        toM(m, res);
    }

    private static void toM(int m, int res) {
        StringBuffer sb = new StringBuffer();

        if (m > 10) {
            while (res != 0) {
                int x = res % m;
                sb.append(changeToChar(x));
                res = res / m;
            }
        } else {
            while (res != 0) {
                sb.append(res % m);
                res = res / m;
            }
        }


        sb.reverse();
        System.out.println(sb.toString());
    }

    private static int toTen(int n, char[] s) {
        int res = 0;
        if (n > 10) {
            for (int i = 0; i < s.length; i++) {
                res = res * n + changeToNumber(s[i]);
            }
        } else {
            for (int i = 0; i < s.length; i++) {
                res = res * n + s[i] - '0';
            }
        }

        return res;
    }

    public static int changeToNumber(char x) {

        if (x == 'A') {
            return 10;
        } else if (x == 'B') {
            return 11;
        } else if (x == 'C') {
            return 12;
        } else if (x == 'D') {
            return 13;
        } else if (x == 'E') {
            return 14;
        } else if (x == 'F') {
            return 15;
        }

        return x - '0';
    }

    public static char changeToChar(int x) {

        if (x == 10) {
            return 'A';
        } else if (x == 11) {
            return 'B';
        } else if (x == 12) {
            return 'C';
        } else if (x == 13) {
            return 'D';
        } else if (x == 14) {
            return 'E';
        } else if (x == 15) {
            return 'F';
        }

        return (char) (x + '0');
    }

}
