package com.miao.algorithm.leetcode;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-04-25
 * @Copyright：
 */
public class FiveFive {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        canJump(nums);
    }

    public static boolean canJump(int[] nums) {
        int[] dp = new int[nums.length + 10];
        for(int i=0; i<=nums[0]; i++){
            dp[i]+=1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= nums[i] && (i+j)<=nums.length && dp[i] != 0; j++) {
                dp[i + j] += 1;
            }
        }

        if (dp[nums.length - 1] != 0) {
            return true;
        }

        return false;
    }
}
