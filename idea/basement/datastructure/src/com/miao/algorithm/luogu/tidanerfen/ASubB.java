package com.miao.algorithm.luogu.tidanerfen;

import java.io.*;
import java.util.Arrays;

public class ASubB {
    static int N = 200010;
    static int[] a = new int[N];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        int c = Integer.parseInt(s[1]);

        String[] s1 = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s1[i]);
        }

        Arrays.sort(a, 0, n);

        //此题最后答案要用long来存
        long res = 0;

        //双指针
        /*int r1 = n - 1;
        int r2 = n - 1;
        int sum;
        for (int i = 0; i < n; i++) {
            sum = a[i] + c;
            while (i < r1 && sum < a[r1]) {
                r1--;
            }
            while (i < r2 && sum <= a[r2]) {
                r2--;
            }

            if (a[r1]==sum && a[r2+1]==sum ){
                res += r1 - r2;
            }
        }*/
        //二分法
        for (int i = 0; i < n; i++) {
            int b = a[i];
            int x = c + b;
            int l = findL(x);
            int r = findR(x);
            if (l != -1 && r != -1) {
                res += r - l ;
            }
        }
        bw.write(res + "\n");
        bw.flush();
        bw.close();
    }


    public static int findL(int x) {
        int l = -1;
        int r = n;
        int mid;
        while (l + 1 != r) {
            mid = l + r >> 1;
            if (x > a[mid]) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static int findR(int x) {
        int l = -1;
        int r = n;
        int mid;
        while (l + 1 != r) {
            mid = l + r >> 1;
            if (a[mid] <= x) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
