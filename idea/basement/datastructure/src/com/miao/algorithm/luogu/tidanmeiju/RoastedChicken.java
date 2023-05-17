package com.miao.algorithm.luogu.tidanmeiju;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RoastedChicken {
    static List<int[]> list = new ArrayList<>();
    static int N = 4;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n < 10 || n > 30) {
            System.out.println(0);
            return;
        }

        for (int a0 = 1; a0 < N; a0++) {
            for (int a1 = 1; a1 < N; a1++) {
                for (int a2 = 1; a2 < N; a2++) {
                    for (int a3 = 1; a3 < N; a3++) {
                        for (int a4 = 1; a4 < N; a4++) {
                            for (int a5 = 1; a5 < N; a5++) {
                                for (int a6 = 1; a6 < N; a6++) {
                                    for (int a7 = 1; a7 < N; a7++) {
                                        for (int a8 = 1; a8 < N; a8++) {
                                            for (int a9 = 1; a9 < N; a9++) {
                                                int sum = a0 + a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8 + a9;
                                                if (sum == n) {
                                                    int[] a = {a0, a1, a2, a3, a4, a5, a6, a7, a8, a9};
                                                    list.add(a);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(list.size());
        for (int[] ints : list) {
            for (int i = 0; i < 10; i++) {
                System.out.print(ints[i]+" ");
            }
            System.out.println();
        }
    }
}
