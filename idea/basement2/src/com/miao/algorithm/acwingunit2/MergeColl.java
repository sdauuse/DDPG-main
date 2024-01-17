package com.miao.algorithm.acwingunit2;

import java.util.Scanner;

public class MergeColl {
    public static int N = (int) (1e5 + 10);
    public static int[] p = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        for (int i = 0; i < m; i++) {
            String op = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (op.equals("M")) {
                p[find(a)] = find(b);
            } else if (op.equals("Q")) {
                int pa = find(a);
                int pb = find(b);
                if (pa==pb){
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }
        }
    }

    private static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
