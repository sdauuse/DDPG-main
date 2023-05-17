package com.miao.algorithm.luogu.tidanmathproblem;

import java.util.Scanner;

public class Coding {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        long ans = 0;

        for(int i=1;i<n;i++){

            if(s.charAt(i)<=s.charAt(i-1)){
                System.out.println(0);
                return;
            }
        }

        for (int i = 1; i < n; i++) {
            ans += c(i, 26);
        }
        //枚举每一位
        for (int i = 0; i < n; i++) {
            //注意考虑边界
            for (char j = (i == 0 ? 'a' : (char) (s.charAt(i - 1) + 1)); j < s.charAt(i); j++) {
                //因为字符串下标从0开始，所以是n-i-1而不是n-i
                ans += c(n - i - 1, 'z' - j);
            }
        }
        System.out.println(++ans);
    }

    public static int getNumber(char c) {

        if (c == 'a') {
            return 1;
        } else {
            return getNumber((char) (c - 1)) + 1;
        }
    }

    //C^a_b
    public static int c(int a, int b) {
        if (a == 0) {
            return 1;
        }
        int res = 1;
        for (int i = b; i > b - a; i--) {
            res = res * i;
        }

        for (int i = a; i > 0; i--) {
            res = res / i;
        }
        return res;
    }
}
