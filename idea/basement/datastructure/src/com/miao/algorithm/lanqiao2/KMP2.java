package com.miao.algorithm.lanqiao2;

import java.io.*;

public class KMP2 {
    static final int N = 1000010;
    static int[] next = new int[N];
    static char[] p;
    static char[] s;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        String s1 = " " + bf.readLine();
        int m = Integer.parseInt(bf.readLine());
        String s2 = " " + bf.readLine();

        p = s1.toCharArray();
        s = s2.toCharArray();

        getNext(n);

        for (int i = 1, j = 0; i <= m; i++) {
            while (j != 0 && s[i] != p[j + 1]) {
                j = next[j];
            }

            if (s[i] == p[j + 1]) {
                j++;
            }
            if (j == n) {
                j = next[j];
                bw.write(i - n + " ");
            }
        }

        bw.flush();
        bw.close();
        bf.close();
    }

    public static void getNext(int n) {
        for (int i = 2, j = 0; i <= n; i++) {
            while (j != 0 && p[i] != p[j + 1]) {
                j = next[j];
            }

            if (p[i] == p[j + 1]) {
                j++;
            }
            next[i] = j;
        }
    }
}
