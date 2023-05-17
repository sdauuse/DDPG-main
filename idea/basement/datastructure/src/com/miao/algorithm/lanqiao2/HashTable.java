package com.miao.algorithm.lanqiao2;


import java.util.Scanner;

public class HashTable {
    static final int N = 200003;
    static final int nullNum = 0x3f3f3f;
    static int[] ht = new int[N];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        for (int i = 0; i < N; i++) {
            ht[i] = nullNum;
        }

        ops(n);
    }

    private static void ops(int n) {
        for (int i = 0; i < n; i++) {
            String query = sc.next();
            int x = sc.nextInt();
            if (query.equals("I")) {
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

        while (ht[pos] != nullNum && ht[pos] != x) {
            pos++;
            if (pos == N) {
                pos = 0;
            }
        }

        return pos;
    }

}
