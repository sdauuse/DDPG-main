package com.miao.algorithm.sort;

public class Quick {
    public static void sort(Comparable[] arr) {
        int low = 0;
        int high = arr.length - 1;

        quickSort(arr, low, high);
    }

    public static void quickSort(Comparable[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        Comparable base = arr[low];
        int l = low;
        int r = high;

        while (l < r) {
            while (l < r && lessEqual(arr[r], base)) {
                r--;
            }

            while (l < r && lessEqual(base, arr[l])) {
                l++;
            }

            if (l <= r) {
                exchange(arr, l, r);
            }

        }

        arr[low] = arr[l];
        arr[l] = base;
        quickSort(arr, low, l - 1);
        quickSort(arr, l + 1, high);

    }


    public static boolean lessEqual(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) <= 0;
    }

    public static void exchange(Comparable[] arr, int i, int j) {
        Comparable temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
