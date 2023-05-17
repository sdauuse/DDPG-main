package com.miao.algorithm.dayday3;

import java.util.Scanner;

public class Trie {
    static final int N = 100010;
    static int[][] son = new int[N][26];
    static int[] cnt = new int[N];
    static int idx = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String q = sc.next();
            String str = sc.next();

            if (q.equals("I")) {
                insert(str);
            } else {
                System.out.println(query(str));
            }
        }
    }

    private static void insert(String str) {
        int p = 0;
        for (int i = 0; i < str.length(); i++) {
            int u = str.charAt(i) - 'a';
            if (son[p][u] == 0) {
                son[p][u] = ++idx;
            }
            p = son[p][u];
        }
        cnt[p]++;
    }

    private static int query(String str) {
        int p = 0;
        for (int i = 0; i < str.length(); i++) {
            int u = str.charAt(i) - 'a';
            if (son[p][u] == 0) {
                return 0;
            }
            p = son[p][u];
        }
        return cnt[p];
    }
}
