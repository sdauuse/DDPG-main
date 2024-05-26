package com.miao.algorithm.leetcode;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-28
 * @Copyright：
 */
public class Eight {
    public static void main(String[] args) {
        String s = "  -4193 with words";
        int res = myAtoi(s);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(res);
    }

    public static int myAtoi(String s) {
        s = s.trim();
        int sign = 1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                sign = -1;
                continue;
            }
            if (i == 0 && s.charAt(i) == '+') {
                sign = 1;
                continue;
            }

            if (Character.isDigit(s.charAt(i))) {
                int temp = s.charAt(i) - '0';
                //如果res*10比最大值还要大，肯定会溢出；
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }

                if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && -temp < Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + sign * temp;
            } else {
                break;
            }
        }

        return res;
    }
}
