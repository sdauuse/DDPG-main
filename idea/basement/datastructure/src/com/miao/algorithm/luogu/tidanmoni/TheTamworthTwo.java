package com.miao.algorithm.luogu.tidanmoni;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheTamworthTwo {
    static int N = 20;
    static char[][] g = new char[N][N];

    // 上 右 下 左
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int da = 0;
    static int db = 0;
    static int n = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int xa = 0;
        int xb = 0;
        int ya = 0;
        int yb = 0;
        for (int i = 1; i <= n; i++) {
            String s = bf.readLine();
            for (int j = 1; j <= n; j++) {
                char x = s.charAt(j - 1);
                if (x == 'F') {
                    xa = i;
                    ya = j;
                } else if (x == 'C') {
                    xb = i;
                    yb = j;
                }
                g[i][j] = x;
            }
        }

        int res = 0;

        for (int i = 0; i < 1e7 + 10; i++) {
            res++;
            if (i >= 1e7) {
                System.out.println(0);
                return;
            }

            if (checkA(xa, ya)) {
                xa = xa + dx[da];
                ya = ya + dy[da];
            } else {
                da = (da + 1) % 4;
            }

            if (checkB(xb, yb)) {
                xb = xb + dx[db];
                yb = yb + dy[db];
            } else {
                db = (db + 1) % 4;
            }

            if (xa == xb && ya == yb) {
                System.out.println(res);
                return;
            }

        }

    }

    private static boolean checkB(int xb, int yb) {
        xb = xb + dx[db];
        yb = yb + dy[db];
        if (xb <= n && xb >= 1 && yb <= n && yb >= 1 && g[xb][yb] != '*') {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkA(int xa, int ya) {
        xa = xa + dx[da];
        ya = ya + dy[da];
        if (xa <= n && xa >= 1 && ya <= n && ya >= 1 && g[xa][ya] != '*') {
            return true;
        } else {
            return false;
        }
    }
}
