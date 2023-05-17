package com.miao.algorithm.repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UnionArray {
    static final int N = 100010;
    static int[] f = new int[N];
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        for (int i = 1; i <= n; i++) {
            f[i] = i;
        }

        ops(m);
    }

    private static void ops(int m) throws IOException {

        for (int i = 0; i < m; i++) {
            String[] s = bf.readLine().split(" ");
            String op = s[0];
            int a = Integer.parseInt(s[1]);
            int b = Integer.parseInt(s[2]);
            int fa = find(a);
            int fb = find(b);
            if (op.equals("M")) {
                if (fa != fb) {
                    f[fa] = fb;
                }
            } else {
                if (fa==fb){
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }
        }
    }

    public static int find(int x) {

        if (f[x] != x) {
            f[x] = find(f[x]);
        }
        return f[x];
    }
}
