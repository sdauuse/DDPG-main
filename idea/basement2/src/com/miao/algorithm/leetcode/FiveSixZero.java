package com.miao.algorithm.leetcode;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-04-23
 * @Copyright：
 */
public class FiveSixZero {
    public static void main(String[] args) {
        int[] nums = {1};
        int k = 0;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            preSum[i] += preSum[i - 1] + nums[i - 1];
        }
        int res = 0;

        int left = 0;
        int right = 1;
        while (right <= nums.length) {
            if (preSum[right] - preSum[left] == k) {
                res++;
                right++;
            } else if (preSum[right] - preSum[left] > k) {
                left++;
                right++;
            } else {
                right++;
            }

        }

        return res;
    }
}
