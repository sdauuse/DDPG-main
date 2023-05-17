package com.miao.algorithm.test;

import com.miao.algorithm.sort.Bubble;
import com.miao.algorithm.sort.Selection;

import java.util.Arrays;

public class SelectionTest {
    public static void main(String[] args) {
        Integer[] arr = {4, 5, 6, 3, 2, 1};

        Selection.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
