package com.miao.algorithm.luogu.tidanmathproblem;

import java.util.Scanner;

public class PrimeMiDu {
    static int N = 500010;
    static int M = 1000005;
    static boolean[] com = new boolean[M];
    static boolean[] isPrime = new boolean[M];
    static long[] pri = new long[M];
    static int idx = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        long r = sc.nextLong();

        //特判l=1的情况
        l += (l == 1) ? 1 : 0;
        if (l > r) {
            System.out.println(0);
            return;
        }
        preOp();

        for (long i = 0; pri[(int) i] <= r / pri[(int) i]; i++) {
            long p = pri[(int) i];

            //我们从大于L的最小的能被p整除的数开始,(l+p-1)就等于ceil(l+p-1),因为有可能会在接下来筛的过程中把自己也一起筛掉,所以在此特判一下
            long start = Math.max(2 * p, (l + pri[(int) i] - 1) / pri[(int) i] * pri[(int) i]);
            for (long j = start; j <= r; j = j + p) {
                isPrime[(int) (j - l)] = true;
            }

        }
        long res = 0;
        for (long i = l; i <= r; i++) {
            if (!isPrime[(int) (i - l)]) {
                res++;
            }
        }

        System.out.println(res);

    }

    private static void preOp() {

        for (int i = 2; i < N; i++) {
            if (!com[i]) {
                pri[idx++] = i;
            }

            for (int j = 0; pri[j] <= N / i; j++) {
                com[(int) (pri[j] * i)] = true;
                if (i % pri[j] == 0) {
                    break;
                }
            }
        }
    }
}
