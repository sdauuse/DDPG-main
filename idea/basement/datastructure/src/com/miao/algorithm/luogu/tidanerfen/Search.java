package com.miao.algorithm.luogu.tidanerfen;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Search {
    static int N = 1000002;
    static int[] a = new int[N];
    static int n;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }


        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();


            int l = 0;
            int r = n;
            while (l + 1 != r) {
                int mid = l + r >> 1;
                if (a[mid] >= x) {
                    r = mid;
                } else {
                    l = mid;
                }
            }

            if (a[r] == x) {
                bw.write(r + " ");
            } else {
                bw.write(-1 + " ");
            }
        }

        bw.flush();
        bw.close();
    }

}
