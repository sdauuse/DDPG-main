package com.miao.algorithm.sort;

public class Selection {
    public static void sort(Comparable[] arr) {
        Comparable max;
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (greater(arr[j], arr[i])) {
                    index = j;
                }
            }
            exchange(arr, i, index);
        }

    }

    public static boolean greater(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) > 0;
    }


    public static void exchange(Comparable[] arr, int i, int j) {
        Comparable c;
        c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
