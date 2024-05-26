package com.miao.algorithm.leetcode;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-30
 * @Copyright： cbaaaaba
 */
public class Five {
    public static void main(String[] args) {
        String s = "cbbd";
        longestPalindrome(s);
    }

    public static String longestPalindrome(String s) {

        if (s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        int length = s.length();
        int maxStart = 0;
        int maxLength = 1;
        for (int i = 0; i < length; i++) {
            int curIdx = i;
            int left = i;
            int right = i;

            while (left != 0) {
                if (chars[left - 1] == chars[curIdx]) {
                    left--;
                } else {
                    break;
                }
            }

            while (right != length - 1) {
                if (chars[curIdx] == chars[right + 1]) {
                    right++;
                } else {
                    break;
                }
            }

            while (left != 0 && right != length - 1) {
                if (chars[left-1] == chars[right+1]) {
                    left--;
                    right++;
                } else {
                    break;
                }
            }

            int temp = right - left + 1;
            if (maxLength < temp) {
                maxLength = temp;
                maxStart = left;
            }
        }
        return s.substring(maxStart, maxStart + maxLength);
    }
}
