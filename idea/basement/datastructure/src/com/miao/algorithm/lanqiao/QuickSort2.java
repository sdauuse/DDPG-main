package com.miao.algorithm.lanqiao;

import java.util.Scanner;

public class QuickSort2 {

    public static int[] array;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        quickSort();

        System.out.print(array[k - 1] + " ");
    }

    public static void quickSort() {
        int low = 0;
        int high = array.length - 1;
        quickSort(low, high);
    }

    public static void quickSort(int low, int high) {

        if (low >= high) {
            return;
        }

        int l = low;
        int r = high;
        int base = array[low];

        while (l < r) {
            while (l < r && base <= array[r]) {
                r--;
            }

            while (l < r && base >= array[l]) {
                l++;
            }

            if (l < r) {
                exchange(l, r);
            }
        }

        array[low] = array[l];
        array[l] = base;
        quickSort(low, l - 1);
        quickSort(l + 1, high);

    }

    public static void exchange(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
