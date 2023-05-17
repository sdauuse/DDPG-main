package com.miao.algorithm.luogu.tidanmeiju;

import java.util.Scanner;

public class NationalFlag {
    static int N = 60;
    static char[][] chars = new char[N][N];
    static int totalAns = 0x3f3f3f3f;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            char[] temp = sc.next().toCharArray();
            for (int j = 1; j <= m; j++) {
                chars[i][j] = temp[j - 1];
            }
        }

        int ans = 0;
        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                ans = 0;
                for (int k = 1; k <= i; k++) {
                    for (int g = 1; g <= m; g++) {
                        if (chars[k][g] != 'W') {
                            ans++;
                        }
                    }
                }

                for (int k = i + 1; k <= j; k++) {
                    for (int g = 1; g <= m; g++) {
                        if (chars[k][g] != 'B') {
                            ans++;
                        }
                    }
                }

                for (int k = j + 1; k <= n; k++) {
                    for (int g = 1; g <= m; g++) {
                        if (chars[k][g] != 'R') {
                            ans++;
                        }
                    }
                }
                totalAns = Math.min(ans, totalAns);
            }
        }

        System.out.println(totalAns);
    }
}
