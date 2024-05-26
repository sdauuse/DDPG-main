package com.miao.algorithm.webank;

import java.util.Scanner;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-31
 * @Copyright：
 */
public class One {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ops = new int[n];
        int[][] cube = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        for (int i = 0; i < n; i++) {
            ops[i] = sc.nextInt();
        }

        for (int op : ops) {
            cube = perOps(cube, op);
        }
        for (int[] row : cube) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

    }

    private static int[][] perOps(int[][] cube, int op) {
        int[][] res = new int[3][3];
        switch (op){
            case 1:
                res[0][0] = cube[0][2];
                res[0][1] = cube[0][0];
                res[0][2] = cube[0][1];
                res[1] = cube[1].clone();
                res[2] = cube[2].clone();
                break;
            case 2:
                res[0] = cube[0].clone();
                res[1][0] = cube[1][2];
                res[1][1] = cube[1][0];
                res[1][2] = cube[1][1];
                res[2] = cube[2].clone();
                break;
            case 3:
                res[0] = cube[0].clone();
                res[1] = cube[1].clone();
                res[2][0] = cube[2][2];
                res[2][1] = cube[2][0];
                res[2][2] = cube[2][1];
                break;
            case 4:
                res[0][0] = cube[1][0];
                res[0][1] = cube[0][1];
                res[0][2] = cube[0][2];
                res[1][0] = cube[2][0];
                res[1][1] = cube[1][1];
                res[1][2] = cube[1][2];
                res[2][0] = cube[0][0];
                res[2][1] = cube[2][1];
                res[2][2] = cube[2][2];
                break;
            case 5:
                res[0][0] = cube[0][0];
                res[0][1] = cube[1][1];
                res[0][2] = cube[0][2];
                res[1][0] = cube[1][0];
                res[1][1] = cube[2][1];
                res[1][2] = cube[1][2];
                res[2][0] = cube[2][0];
                res[2][1] = cube[0][1];
                res[2][2] = cube[2][2];
                break;
            case 6:
                res[0][0] = cube[0][0];
                res[0][1] = cube[0][1];
                res[0][2] = cube[1][2];
                res[1][0] = cube[1][0];
                res[1][1] = cube[1][1];
                res[1][2] = cube[2][2];
                res[2][0] = cube[2][0];
                res[2][1] = cube[2][1];
                res[2][2] = cube[0][2];
                break;
        }
        return res;
    }
}