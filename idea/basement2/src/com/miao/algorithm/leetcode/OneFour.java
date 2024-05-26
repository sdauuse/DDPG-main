package com.miao.algorithm.leetcode;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-04-24
 * @Copyright：
 */
public class OneFour {
    public static void main(String[] args) {
        String[] strs = {"ab", "a"};

        longestCommonPrefix(strs);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String res = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < strs[i].length() && j < res.length(); j++) {
                if (res.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
                j++;
            }

            res = strs[i].substring(0,j);
        }
        int v = (int) (Math.log(16) / Math.log(2));
        return res;
    }
}
