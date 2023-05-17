package com.miao.algorithm.acwing1;

import java.util.ArrayList;
import java.util.List;

public class SumEqualS {

    public static void main(String[] args) {
        List<List<Integer>> continuousSequence = findContinuousSequence(15);
        for (List<Integer> list : continuousSequence) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> findContinuousSequence(int sum) {
        List<List<Integer>> list = new ArrayList<>();
        int left = 0;
        int right = 1;
        int res = 0;
        while (right < sum) {
            if (res < sum) {
                res += right;
                right++;
            } else if (res > sum) {
                left++;
                res -= left;
            } else {
                List<Integer> temp = new ArrayList<>();
                for (int i = left + 1; i < right; i++) {
                    temp.add(i);
                }
                list.add(temp);
                res += right;
                right++;
            }
        }
        return list;
    }

    public static List<List<Integer>> findContinuousSequence2(int sum) {
        List<List<Integer>> res = new ArrayList<>();
        int left = 1, right = 1, value = 0;
        while (right < sum) {
            value += right;
            right++;
            while (value > sum) {
                value -= left;
                left++;
            }
            if (value == sum) {
                List<Integer> list = new ArrayList<>();
                for (int k = left; k < right; k++) {
                    list.add(k);
                }
                res.add(new ArrayList<>(list));
            }
        }
        return res;
    }
}
