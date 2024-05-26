package com.miao.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-04-07
 * @Copyright：
 */
public class FiveSix {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {

            if (idx == -1 || res[idx][1] < interval[0]) {
                res[++idx] = interval;
            } else {
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }

        return Arrays.copyOf(res, idx + 1);
    }

}
