package com.miao.algorithm.luogu.tidanchafen;

import java.io.*;

public class Carpet {
    static int N = 1002;
    static int[][] a = new int[N][N];
    static int[][] b = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        for (int i = 1; i <= m; i++) {
            String[] s1 = bf.readLine().split(" ");
            int x1, y1, x2, y2;
            x1 = Integer.parseInt(s1[0]);
            y1 = Integer.parseInt(s1[1]);
            x2 = Integer.parseInt(s1[2]);
            y2 = Integer.parseInt(s1[3]);
            insert(x1, y1, x2, y2, 1);
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1] + b[i][j];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                bw.write(a[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        bf.close();
    }


    public static void insert(int x1, int y1, int x2, int y2, int c) {
        b[x1][y1] += c;
        b[x2 + 1][y1] -= c;
        b[x1][y2 + 1] -= c;
        b[x2 + 1][y2 + 1] += c;
    }
}
