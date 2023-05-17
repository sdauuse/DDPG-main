package com.miao.algorithm.lanqiao;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] arr = in.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(arr[i]);
        }


        quickSort(a);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void quickSort(int[] array) {
        int low = 0;
        int high = array.length - 1;
        quickSort(array, low, high);
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        int base = array[low];
        int l = low;
        int r = high;

        while (l < r) {
            while (base <= array[r] && l < r) {
                r--;
            }

            while (base >= array[l] && l < r) {
                l++;
            }

            if (l < r) {
                exchange(array, l, r);
            }
        }

        array[low] = array[l];
        array[l] = base;
        quickSort(array, low, l - 1);
        quickSort(array, l + 1, high);


    }


    public static void exchange(int[] array, int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
