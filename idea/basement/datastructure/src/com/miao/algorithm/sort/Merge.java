package com.miao.algorithm.sort;

public class Merge {
    //归并所需要的辅助数组
    private static Comparable[] assist;

    public static void sort(Comparable[] arr) {
        assist = new Comparable[arr.length];
        int low = 0;
        int high = assist.length - 1;
        sort(arr, low, high);
    }

    private static void sort(Comparable[] arr, int low, int high) {
        if (high <= low) {
            return;
        }
        int middle = low + (high - low) / 2;

        sort(arr, low, middle);
        sort(arr, middle + 1, high);

        merge(arr, low, middle, high);

    }

    private static void merge(Comparable[] arr, int low, int middle, int high) {
        int p1 = low;
        int p2 = middle + 1;
        int index = low;
        while (p1 <= middle && p2 <= high) {
            if (less(arr[p1], arr[p2])) {
                assist[index++] = arr[p1++];
            } else {
                assist[index++] = arr[p2++];
            }
        }

        while (p1 <= middle) {
            assist[index++] = arr[p1++];
        }

        while (p2 <= high) {
            assist[index++] = arr[p2++];
        }

        for (int i = low; i <= high; i++) {
            arr[i] = assist[i];
        }
    }

    public static boolean less(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) < 0;
    }

    public static void exchange(Comparable[] arr, int i, int j) {
        Comparable temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
