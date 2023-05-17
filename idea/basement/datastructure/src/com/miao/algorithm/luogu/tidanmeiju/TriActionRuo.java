package com.miao.algorithm.luogu.tidanmeiju;

public class TriActionRuo {

    static int[] p = new int[20];
    static int ans = 0;
    static boolean flag = true;

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int b1, b2, b3;

        for (int i = 1; i <= 1000 / c; i++) {
            b1 = i * a;
            b2 = i * b;
            b3 = i * c;

            if (b2 > 999 || b3 > 999) {
                break;
            }

            for (int j = 0; j < 3; j++) {
                p[b1 % 10]++;
                b1 /= 10;
            }

            for (int j = 0; j < 3; j++) {
                p[b2 % 10]++;
                b2 /= 10;
            }

            for (int j = 0; j < 3; j++) {
                p[b3 % 10]++;
                b3 /= 10;
            }

            for (int j = 1; j <= 9; j++) {
                if (p[j] != 1) {
                    flag = false;
                    break;
                }
            }

            for (int j = 1; j <= 9; j++) {
                p[j] = 0;
            }

            if (flag) {
                System.out.println(i * a + " " + i * b + " " + i * c);
            } else {
                flag = true;
            }

        }
    }
}
