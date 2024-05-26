package com.miao.algorithm.leetcode;

import java.util.Arrays;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-23
 * @Copyright：
 */
public class OneTwoEigh {
    public static void main(String[] args) {
        int[] nums = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        longestConsecutive(nums);
    }

    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int res = 1;
        int tempLen = 1;
        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] == nums[i + 1]) {
                continue;
            }

            int temp = nums[i] + 1;
            if (temp == nums[i + 1]) {
                tempLen++;
            } else {
                res = Math.max(res, tempLen);
                tempLen = 1;
            }

        }

        res = Math.max(res, tempLen);
        return res;
    }
}
