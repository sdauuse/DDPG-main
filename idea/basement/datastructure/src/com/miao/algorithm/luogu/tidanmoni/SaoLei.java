package com.miao.algorithm.luogu.tidanmoni;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SaoLei {
    static int N = 110;
    static char[][] c = new char[N][N];
    //上、下、左、右、左上、右上、左下、右下
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, 1, -1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        for (int i = 1; i <= n; i++) {
            String s1 = bf.readLine();
            for (int j = 1; j <= m; j++) {
                c[i][j] = s1.charAt(j - 1);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (c[i][j]=='*'){
                    System.out.print("*");
                }else {
                    int res = check(i, j);
                    System.out.print(res+"");
                }
            }
            System.out.println();
        }

    }

    public static int check(int a, int b) {
        int res = 0;
        for (int i = 0; i < 8; i++) {
            int x = dx[i] + a;
            int y = dy[i] + b;
            if (c[x][y] == '*') {
                res++;
            }
        }

        return res;
    }
}
