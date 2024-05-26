package com.miao.algorithm.leetcode;

import java.util.*;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-23
 * @Copyright：
 */
public class FourNight {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();


        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
