package com.miao.algorithm.luogu.tidanmoni;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TableTennis {
    static int N = 2510;
    static String[] s1 = new String[N];
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        int left = 0;
        int right = 0;

        while (!s.contains("E")) {
            s = bf.readLine();
            s1[idx++] = s;
        }

        for (int j = 0; j < idx; j++) {
            for (int i = 0; i < s1[j].length(); i++) {
                if (s1[j].charAt(i) == 'E') {
                    System.out.println(left + ":" + right);
                    break;
                }

                if (s1[j].charAt(i) == 'W') {
                    left++;
                } else if (s1[j].charAt(i)=='L'){
                    right++;
                }

                //要注意比赛规则
                if ((left >= 11 || right >= 11) && Math.abs(left-right)>=2) {
                    System.out.println(left + ":" + right);
                    left = 0;
                    right = 0;
                }

            }
        }

        System.out.println();
        left = 0;
        right = 0;
        for (int j = 0; j < idx; j++) {
            for (int i = 0; i < s1[j].length(); i++) {
                if (s1[j].charAt(i) == 'E') {
                    System.out.println(left + ":" + right);
                    return;
                }

                if (s1[j].charAt(i) == 'W') {
                    left++;
                } else if (s1[j].charAt(i)=='L'){
                    right++;
                }

                if ((left >= 21 || right >= 21) && Math.abs(left-right)>=2) {
                    System.out.println(left + ":" + right);
                    left = 0;
                    right = 0;
                }

            }
        }

    }
}
