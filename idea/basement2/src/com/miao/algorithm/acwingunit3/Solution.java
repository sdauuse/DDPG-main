package com.miao.algorithm.acwingunit3;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-01-19
 * @Copyright：
 */
class Solution {
    static int idx = 0;

    public static void main(String[] args) {
        int[] a = {1};
        int k = 1;
        int kthLargest = findKthLargest(a, k);
        System.out.println(kthLargest);
    }

    public static int findKthLargest(int[] nums, int k) {
        int res;
        int[] h = new int[nums.length + 10];

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            idx++;
            h[idx] = val;
            up(h, idx);
        }

        for (int i = 0; i < k - 1; i++) {
            swap(h, 1, idx);
            idx--;
            down(h, 1);
        }

        res = h[1];

        return res;
    }

    public static void up(int[] h, int x) {
        while (x / 2 > 0 && h[x / 2] < h[x]) {
            swap(h, x / 2, x);
            x = x / 2;
        }
    }

    public static void down(int[] nums, int x) {
        int left = 2 * x;
        int right = 2 * x + 1;
        int max = x;
        if (left <= idx && nums[left] > nums[max]) {
            max = left;
        }
        if (right <= idx && nums[right] > nums[max]) {
            max = right;
        }

        if (max != x) {
            swap(nums, max, x);
            down(nums, max);
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

