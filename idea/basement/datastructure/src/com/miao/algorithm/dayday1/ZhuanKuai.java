package com.miao.algorithm.dayday1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZhuanKuai {
    static final int N = 210;
    static char[] c = new char[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            String s = sc.next();

            for (int j = 0; j < m; j++) {
                c[j] = s.charAt(j);
            }
            if (!check(m, 'B') && !check(m, 'W')) {
                System.out.println("-1");
            }

        }
    }

    private static boolean check(int n, char obj) {
        char[] RC = new char[N];
        for (int i = 0; i < n; i++) {
            RC[i] = c[i];
        }
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (RC[i] != obj) {
                list.add(i);
                count++;
                change(RC, i);
                change(RC, i + 1);
            }
        }
        if (RC[n - 1] == obj) {
            System.out.println(count);
            for (Integer integer : list) {
                System.out.print(integer + 1 + " ");
            }
            if (count!=0){
                System.out.println();
            }
            return true;
        } else {
            return false;
        }
    }

    public static void change(char[] RC, int i) {
        if (RC[i] == 'B') {
            RC[i] = 'W';
        } else {
            RC[i] = 'B';
        }
    }
}
