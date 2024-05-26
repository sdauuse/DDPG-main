package com.miao.algorithm.leetcode;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-23
 * @Copyright：
 */
public class TwoZeroNight {
    public static void main(String[] args) {

    }
    public int minSubArrayLen(int target, int[] nums) {
        int curSum = 0;
        int left = 0;
        int right = 0;
        int res = Integer.MAX_VALUE;
        while(right < nums.length){
            curSum += nums[right];
            while(curSum >= target){
                res = Math.min(res,right-left+1);

                curSum -= nums[left];
                left++;
            }

            right++;
        }

        return res;
    }
}
