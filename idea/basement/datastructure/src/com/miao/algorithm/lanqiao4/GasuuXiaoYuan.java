package com.miao.algorithm.lanqiao4;

import java.util.Scanner;

public class GasuuXiaoYuan {
    static final int N = 110;
    static double[][] g = new double[N][N];
    static final double eps = 1e-6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                g[i][j] = sc.nextDouble();
            }
        }

        int t = gauss(n);
        if (t == 0) {
            for (int i = 0; i < n; i++) {
                System.out.println(String.format("%.2f", g[i][n]));
            }
        } else if (t == 1) {
            System.out.println("Infinite group solutions");
        } else {
            System.out.println("No solution");
        }
    }

    public static void swap(int r1, int c1, int r2, int c2) {
        double temp = g[r1][c1];
        g[r1][c1] = g[r2][c2];
        g[r2][c2] = temp;
    }


    private static int gauss(int n) {
        int c, r;

        for (c = 0, r = 0; c <= n; c++) {
            int t = r;

            for (int i = 0; i < n; i++) {
                if (Math.abs(g[t][c]) < Math.abs(g[i][c])) {
                    t = i;
                }
            }

            if (Math.abs(g[t][c]) < eps) {
                continue;
            }

            for (int i = c; i <= n; i++) {
                swap(r, i, t, i);
            }

            for (int i = n; i >= c; i--) {
                g[r][i] /= g[r][c];
            }

            for (int i = r + 1; i < n; i++) {
                if (Math.abs(g[r][c]) > eps) {
                    // 从后往前，当前行的每个数字，都减去对应列 * 行首非0的数字，这样就能保证第一个数字是 a[i][0] -= 1*a[i][0];
                    for (int j = n; j >= c; j--) {
                        g[i][j] -= g[r][j] * g[i][c];
                    }
                }
            }

            r++;
        }
        if (r < n)// 说明剩下方程的个数是小于 n 的，说明不是唯一解，判断是无解还是无穷多解
        {// 因为已经是阶梯型，所以 r ~ n-1 的值应该都为 0
            for (int i = r; i < n; i++) {

                // a[i][n] 代表 b_i ,即 左边=0，右边=b_i,0 != b_i, 所以无解。
                if (Math.abs(g[i][n]) > eps) {
                    return 2;
                }
            }
            return 1;// 否则， 0 = 0，就是r ~ n-1的方程都是多余方程
        }
        // 唯一解 ↓，从下往上回代，得到方程的解
        for (int i = n - 1; i >= 0; i--) {

            for (int j = i + 1; j < n; j++) {
                g[i][n] -= g[j][n] * g[i][j];//因为只要得到解，所以只用对 b_i 进行操作，中间的值，可以不用操作，因为不用输出

            }
        }


        return 0;
    }
}
