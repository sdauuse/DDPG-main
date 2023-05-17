package com.miao.algorithm.dayday2;

import java.io.*;

public class Members {
    static final int N = 20010;
    static int[] p = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }

        for (int i = 0; i < m; i++) {
            String[] s1 = bf.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            int fa = find(a);
            int fb = find(b);
            p[fa] = fb;
        }

        int q = Integer.parseInt(bf.readLine());
        for (int i = 0; i < q; i++) {
            String[] s2 = bf.readLine().split(" ");
            int a = Integer.parseInt(s2[0]);
            int b = Integer.parseInt(s2[1]);
            int fa = find(a);
            int fb = find(b);
            if (fa==fb){
                bw.write("Yes\n");
            }else {
                bw.write("No\n");
            }
        }
        bw.close();
    }

    public static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
