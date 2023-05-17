package com.miao.algorithm.luogu.tidanmathproblem;


import java.io.*;

public class LinearPrime {
    static int N = 100000010;
    static int M = 6000010;
    static boolean[] com = new boolean[N];
    static int[] pri = new int[M];
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int q = Integer.parseInt(s[1]);

        ops(n);

        for (int i = 0; i < q; i++) {
            int x = Integer.parseInt(bf.readLine());
            bw.write(pri[x] + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void ops(int n) {

        for (int i = 2; i <= n; i++) {
            if (!com[i]) {
                pri[++idx] = i;

            }

            //从小到大枚举所有质数
            //当我们的质数大于n/i时，就break
            for (int j = 1; pri[j] <= n / i; j++) {
                com[pri[j] * i] = true;

                //当下面判断成立时，pri[j]一定是i的最小质因子，同时也是pri[j]*i的最小质因子
                if (i % pri[j] == 0) {
                    break;
                }
            }
        }

    }
}
