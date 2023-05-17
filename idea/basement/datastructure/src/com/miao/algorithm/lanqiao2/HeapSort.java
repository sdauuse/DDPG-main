package com.miao.algorithm.lanqiao2;

import java.util.Scanner;

public class HeapSort {

    static final int N = 100010;
    static int[] h = new int[N];
    static int idx = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            insert(x);
        }

        for (int i = 0; i < m; i++) {
            pop();
        }

    }

    private static void pop() {
        System.out.print(h[1] + " ");
        swap(1, idx);
        idx--;
        down(1);
    }

    public static void insert(int x) {
        h[++idx] = x;
        up();
    }

    private static void down(int i) {
        int index = i;
        int left = i * 2;
        int right = i * 2 + 1;
        if (left <= idx && h[left] < h[index]) {
            index = left;
        }
        if (right <= idx && h[right] < h[index]) {
            index = right;
        }

        if (index != i) {
            swap(i, index);
            down(index);
        }

    }

    private static void up() {
        int now = idx;
        int f = now / 2;
        while (f > 0 && h[now] < h[f]) {
            swap(now, f);
            now = f;
            f = now / 2;
        }
    }

    private static void swap(int i, int j) {
        int temp = h[i];
        h[i] = h[j];
        h[j] = temp;
    }
}
