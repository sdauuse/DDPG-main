package com.miao.algorithm.sort;

public class Insert {
    public static void sort(Comparable[] arr) {

        int index;
        for (int i = 1; i < arr.length; i++) {
            index = i;
            for (int j = i - 1; j >= 0; j--) {
                if (greater(arr[j], arr[index])) {
                    exchange(arr, index, j);
                    index--;
                }else {
                    break;
                }
            }
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
