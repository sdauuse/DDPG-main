package com.miao.algorithm.sort;

public class Bubble {
    public static void sort(Comparable[] arr) {

        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (greater(arr[j], arr[j + 1])) {
                    exchange(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }
            flag = false;
        }
    }

    public static boolean greater(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) > 0;
    }


    public static void exchange(Comparable[] arr, int i, int j) {
        Comparable temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
