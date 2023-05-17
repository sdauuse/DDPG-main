package com.miao.algorithm.test;

import com.miao.algorithm.sort.Shell;

import java.util.Arrays;

public class ShellTest {
    public static void main(String[] args) {
        Integer[] arr = {4, 5, 6, 3, 2, 1};
        // 3 2 1 4 5 6
        Shell.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
