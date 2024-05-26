package com.miao.algorithm.leetcode;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-28
 * @Copyright：
 */
public class EightEight {
    public static void main(String[] args) {
        /*int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;*/
        int[] nums1 = {1};
        int[] nums2 = {};
        int m = 1;
        int n = 0;
        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = n + m - 1;
        int i = total;
        n -= 1;
        m -= 1;
        for (; n >= 0 && m >= 0; i--) {
            if (nums1[m] < nums2[n]) {
                nums1[i] = nums2[n];
                n--;
            } else {
                nums1[i] = nums1[m];
                m--;
            }
        }

        while (m >= 0) {
            nums1[i] = nums1[m];
            m--;
            i--;
        }

        while (n >= 0) {
            nums1[i] = nums2[n];
            n--;
            i--;
        }

    }
}
