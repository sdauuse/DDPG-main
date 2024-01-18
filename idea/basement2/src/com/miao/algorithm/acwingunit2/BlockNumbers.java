package com.miao.algorithm.acwingunit2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-01-18
 * @Copyright：
 */
public class BlockNumbers {
    public static int N = (int) (1e5 + 10);
    public static int[] p = new int[N];
    public static int[] size = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        for (int i = 0; i < n; i++) {
            p[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            String[] s1 = bf.readLine().split(" ");
            if (s1[0].equals("C")) {
                int a = Integer.parseInt(s1[1]);
                int b = Integer.parseInt(s1[2]);
                if (find(a) != find(b)) {
                    size[find(b)] += size[find(a)];
                    p[find(a)] = find(b);
                }
            } else if (s1[0].equals("Q1")) {
                int a = Integer.parseInt(s1[1]);
                int b = Integer.parseInt(s1[2]);
                if (find(a) == find(b)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            } else if (s1[0].equals("Q2")) {
                int a = Integer.parseInt(s1[1]);
                System.out.println(size[find(a)]);
            }
        }
    }

    public static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
