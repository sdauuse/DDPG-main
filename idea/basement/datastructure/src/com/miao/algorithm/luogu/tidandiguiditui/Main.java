package com.miao.algorithm.luogu.tidandiguiditui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer> s0 = new ArrayList<>();
    static List<Integer> s1 = new ArrayList<>();
    static List<Integer> s2 = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 任务数量
        int[][] tasks = new int[n][2];
        for (int i = 0; i < n; i++) {
            tasks[i][0] = sc.nextInt();
            tasks[i][1] = sc.nextInt();
        }
        int preStart = -1;
        int prevEnd = -1; // 上一个任务的结束时间片
        int energy = 0; // 总能耗
        int state = 0; // 当前状态，0表示空载，1表示单任务，2表示多任务
        for (int i = 0; i < n; i++) {

            int start = tasks[i][0];
            int end = tasks[i][1];
            if (i == 0) {
                preStart = start;
                prevEnd = end;
                continue;
            }


            int temp = start - prevEnd;
            if (temp > 0) {
                energy += temp - 1;
                energy += prevEnd - preStart + 1;
                state = 0;
            } else {
                temp = Math.min(end, prevEnd) - start + 1;
                energy += 4 * temp;
                state = 2;
            }

            if (state == 2) {
                if (end > prevEnd) {

                } else {

                }
            } else {
                energy += 3 * (end - start + 1);
            }

            preStart = start;
            prevEnd = end;
        }
        System.out.println(energy);
    }
}
