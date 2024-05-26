package com.miao.algorithm.leetcode;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-30
 * @Copyright：
 */
public class SixFourSeven {

    public static void main(String[] args) {

    }

    public static int countSubstrings(String s) {
        int len = s.length();
        int res = len;
        char[] chars = s.toCharArray();

        for (int i = 0; i < len; i++) {
            int curIdx = i;
            int left = i;
            int right = i;
            while (left != 0) {
                if (chars[left - 1] == chars[curIdx]) {
                    res++;
                    left--;
                } else {
                    break;
                }
            }

            while (right != len - 1) {
                if (chars[right + 1] == chars[curIdx]) {
                    right++;
                    res++;
                } else {
                    break;
                }
            }

            while (left != 0 && right != len - 1) {
                if (chars[left - 1] == chars[right + 1]) {
                    res++;
                    right++;
                    left--;
                } else {
                    break;
                }
            }
        }

        return res;
    }
}
