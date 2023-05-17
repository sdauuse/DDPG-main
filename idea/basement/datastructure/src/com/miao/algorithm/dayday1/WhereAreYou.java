package com.miao.algorithm.dayday1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WhereAreYou {

    static final int N = 110;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();
        for (int i = 1; i <= n; i++) {
            Set<String> set = new HashSet();
            boolean flag = false;
            for (int j = 0; j + i <= n; j++) {
                String subS = str.substring(j, j + i);
                if (set.contains(subS)) {
                    flag = true;
                    break;
                }
                set.add(subS);
            }

            if (!flag) {
                System.out.println(i);
                return;
            }
        }
    }
   /* static final int P = 131;
    static final int N = 110;
    static final int mod = (int) Math.pow(2, 64);
    static int[] h = new int[N];
    static int[] p = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * P;
            h[i] = (h[i - 1] * P + s.charAt(i - 1)) % mod;
        }
        int count = 1;
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            flag = false;
            for (int j = i + 1; j <= n; j++) {
                if (get(j - i + 1, j) == h[i]) {
                    flag = true;
                    break;x
                }
            }
            if (!flag){
                System.out.println(count);
                return;
            }
            count++;
        }

        System.out.println(count);
    }


    public static long get(int l, int r) {

        return h[r] - h[l - 1] * p[r - l + 1];
    }*/

}
