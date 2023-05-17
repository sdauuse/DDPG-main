package com.miao.algorithm.luogu.tidanchafen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Honor {
    static int N = 1000005;
    static long[] a = new long[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(bf);

        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;


        for (int i = 1; i <= n - 1; i++) {
            in.nextToken();
            long temp = (long) in.nval;
            a[i] = a[i - 1] + temp;
        }

        long max = 0;
        for (int i = 0; i + k <= n - 1; i++) {
            max = Math.max(a[i + k] - a[i], max);
        }

        System.out.println(a[n - 1] - max);
    }
}
