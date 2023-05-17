package com.miao.algorithm.lanqiao4;

import java.util.*;

public class CompositionNumber {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();

            compositionNumber(x);
        }
    }

    private static void compositionNumber(int x) {
        List<Integer> com = new ArrayList<>();

        for (int i = 1; i <= x / i; i++) {
            if (x % i == 0) {
                com.add(i);
                if (i != x / i) {
                    com.add(x / i);
                }
            }
        }

        Collections.sort(com);

        for (Integer integer : com) {
            System.out.print(integer + " ");
        }

        System.out.println();
    }
}
