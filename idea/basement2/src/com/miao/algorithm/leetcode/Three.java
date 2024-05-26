package com.miao.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-23
 * @Copyright：
 */
public class Three {
    public static void main(String[] args) {
        String s = "abcabcbb";
        lengthOfLongestSubstring(s);
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right);

            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            right++;
            res = Math.max(res, set.size());
        }

        return res;
    }
}
