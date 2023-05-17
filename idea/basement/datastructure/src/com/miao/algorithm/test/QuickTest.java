package com.miao.algorithm.test;

import com.miao.algorithm.sort.Insert;
import com.miao.algorithm.sort.Quick;

import java.util.Arrays;

public class QuickTest {
    public static void main(String[] args) {
        Integer[] arr = {8, 4, 5, 7, 1, 3, 6, 2};

        Quick.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
