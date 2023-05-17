package com.miao.algorithm.dayday2;

import java.util.Scanner;

public class HashTable {
    static final int N = 200009;
    static final int INF = 0x3f3f3f3f;
    static int[] ht = new int[N];

    public static void main(String[] args) {

        for (int i = 0; i < N; i++) {
            ht[i] = INF;
        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String ops = sc.next();
            int x = sc.nextInt();
            if (ops.equals("I")) {
                int pos = find(x);
                ht[pos] = x;
            } else {
                int pos = find(x);
                if (ht[pos]==x){
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }
        }
    }

    private static int find(int x) {
        int pos = ((x % N) + N) % N;

        while (ht[pos] != INF && ht[pos] != x) {
            pos++;
            if (pos == N) {
                pos = 0;
            }
        }
        return pos;
    }
}
