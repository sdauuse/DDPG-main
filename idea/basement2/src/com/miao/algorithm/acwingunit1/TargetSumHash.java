package com.miao.algorithm.acwingunit1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TargetSumHash {

    public static int N = (int) (1e5 + 10);
    public static int[] a = new int[N];
    public static int[] b = new int[N];
    public static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int j = 0; j < m; j++) {
            b[j] = sc.nextInt();
        }

        method(n, m, x);
    }

    private static void method(int n, int m, int x) {
        for (int i = 0; i < n; i++) {
            int temp = x - a[i];
            map.put(temp, i);
        }

        for (int i = 0; i < m; i++) {
            Integer j = map.get(b[i]);
            if (j != null) {
                System.out.println(j + " " + i);
            }
        }
    }
}
