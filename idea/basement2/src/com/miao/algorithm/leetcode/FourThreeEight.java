package com.miao.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-24
 * @Copyright：
 */
public class FourThreeEight {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int val = 0;
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            r++;
            if (map.containsKey(c)) {
                int total = window.getOrDefault(c, 0) + 1;
                window.put(c, total);
                if (window.get(c).equals(map.get(c))) {
                    val++;
                }
            }

            while (r - l >= p.length()) {
                if (val == map.size()) {
                    res.add(l);
                }

                char d = s.charAt(l);
                l++;
                if (map.containsKey(d)) {
                    if (window.get(d).equals(map.get(d))) {
                        val--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return res;
    }
}
