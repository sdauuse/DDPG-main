package com.miao.algorithm.lanqiao2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SingleQueue {
    static final int N = 1000010;
    static int[] a = new int[N];
    static int[] q = new int[N];
    static int hh = 0, tt = -1;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String s = bf.readLine();
        String[] s1 = s.split(" ");

        int n = Integer.parseInt(s1[0]);
        //k 为滑动窗口大小
        int k = Integer.parseInt(s1[1]);

        singleQueue(n, k);
    }

    private static void singleQueue(int n, int k) throws IOException {

        String s = bf.readLine();
        String[] s1 = s.split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s1[i]);
        }

        for (int i = 0; i < n; i++) {
            if (hh <= tt && q[hh] < i - k + 1) {
                hh++;
            }

            while (hh <= tt && a[q[tt]] >= a[i]) {
                tt--;
            }
            q[++tt] = i;

            //要等到窗口中的元素满了才可以输出。
            if (i + 1 >= k) {
                System.out.print(a[q[hh]] + " ");
            }

        }

        hh = 0;
        tt = -1;
        System.out.println();
        for (int i = 0; i < n; i++) {

            //检查窗口头部的合法性
            if (hh <= tt && q[hh] < i - k + 1) {
                hh++;
            }

            while (hh <= tt && a[q[tt]] <= a[i]) {
                tt--;
            }

            q[++tt] = i;

            if (i + 1 >= k) {
                System.out.print(a[q[hh]] + " ");
            }

        }
    }
}
