package com.miao.algorithm.acwingunit2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-01-18
 * @Copyright：
 */
public class HeapSort {
    public static int N = (int) (1e5 + 10);
    public static int[] h = new int[N];
    public static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String[] s1 = bf.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            int x = Integer.parseInt(s1[i - 1]);
            h[++size] = x;
            up();
        }

        for (int i = 0; i < m; i++) {
            pop();
        }
    }

    private static void pop() {
        System.out.print(h[1] + " ");
        swap(1, size);
        size--;
        down(1);
    }

    public static void down(int x) {
        int min = x;
        int left = 2 * x;
        int right = 2 * x + 1;
        if (left <= size && h[left] < h[min]) {
            min = left;
        }
        if (right <= size && h[right] < h[min]) {
            min = right;
        }
        if (min != x) {
            swap(min, x);
            down(min);
        }
    }

    public static void up() {
        int now = size;
        int f = now / 2;
        while (f > 0 && h[f] > h[now]) {
            swap(f, now);
            now = f;
            f = now / 2;
        }
    }

    public static void swap(int a, int b) {
        int temp = h[a];
        h[a] = h[b];
        h[b] = temp;
    }
}
