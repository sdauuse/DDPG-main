package com.miao.algorithm.webank;

import java.util.Scanner;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-31
 * @Copyright：
 */
public class Three {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int s = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            System.out.println(winner(x, s, a, b, c, d));
        }
    }

    private static int winner(int x, int s, int a, int b, int c, int d) {
        int[] dp = new int[s + 1];
        for (int i = x; i <= s; i++) {
            dp[i] = 2;
        }

        for (int i = s - 1; i >= x; i--) {
            boolean redWin = false;
            boolean blueWin = false;
            for (int j = a; j <= b; j++) {
                if (i + j <= s && dp[i + j] == 2) {
                    redWin = true;
                    break;
                }
            }

            for (int j = c; j <= d; j++) {
                if (i + j <= s && dp[i + j] == 1) {
                    blueWin = true;
                    break;
                }
            }

            if (redWin) {
                dp[i] = 1;
            } else if (blueWin) {
                dp[i] = 2;
            } else {
                dp[i] = 1;
            }
        }

        return dp[x];
    }
   /* private static int winner(int x, int s, int a, int b, int c, int d) {
        if (x + b >= s) {
            return 1;
        }
        int midToWin = s - b - d;
        if (x + d >= s || x + b + c >= s) {
            return 2;
        }
        return b >= d ? 1 : 2;
    }*/

}
