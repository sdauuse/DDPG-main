package com.miao.algorithm.luogu.tidanmoni;

import java.util.Scanner;

public class Toy {
    static int N = 100010;
    static PII[] p = new PII[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            p[i] = new PII(sc.nextInt(), sc.next());
        }

        int idx = 0;
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int s = sc.nextInt();
            if ((a ^ p[idx].seq) == 0) {
                idx = (((idx - s) % n) + n) % n;
            } else {
                idx = (idx + s) % n;
            }
        }

        System.out.println(p[idx].name);
    }


    static class PII {
        int seq;
        String name;

        public PII(int seq, String name) {
            this.seq = seq;
            this.name = name;
        }
    }
}
