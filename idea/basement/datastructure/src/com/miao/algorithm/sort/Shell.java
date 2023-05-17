package com.miao.algorithm.sort;

public class Shell {

    public static void sort(Comparable[] arr) {
        int h = 1;
        while (h < arr.length / 2) {
            h = 2 * h + 1;
        }
        // {4, 5, 6, 3, 2, 1}
        while (h >= 1) {
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (greater(arr[j - h], arr[j])) {
                        exchange(arr, j, j - h);
                    } else {
                        break;
                    }
                }
            }
            h = h / 2;
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
