package com.miao.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-22
 * @Copyright：
 */
public class One {

    public static void main(String[] args) {

    }

    static final int N = (int) 1e4 + 10;

    public int[] twoSum(int[] nums, int target) {
        int total = nums.length;
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>(N);
        for (int i = 0; i < total; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < total; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp) && map.get(temp) != i) {
                int l = map.get(temp);

                res[0] = Math.min(l, i);
                res[1] = Math.max(l, i);
                return res;
            }

        }
        return res;
    }
}
