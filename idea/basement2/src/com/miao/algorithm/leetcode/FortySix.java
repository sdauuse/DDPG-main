package com.miao.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-04-04
 * @Copyright：
 */
public class FortySix {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    static int N = 20;

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[N];
        dfs(res, nums, 0, path, visited);
        return res;
    }

    public static void dfs(List<List<Integer>> res, int[] nums, int n, List<Integer> path, boolean[] visited) {
        if (n >= nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (!visited[i]) {
                path.add(nums[i]);
                visited[i] = true;
                dfs(res, nums, n + 1, path, visited);
                visited[i] = false;
                path.remove(path.size() - 1);
            }

        }
    }
}
