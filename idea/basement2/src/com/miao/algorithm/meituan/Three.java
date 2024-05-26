package com.miao.algorithm.meituan;

import java.util.Scanner;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-09
 * @Copyright：
 */
public class Three {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] matrix = new int[n][n];
        int[][] prefixSum0 = new int[n+1][n+1];
        int[][] prefixSum1 = new int[n+1][n+1];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = line.charAt(j)-'0';
                prefixSum0[i+1][j+1] = prefixSum0[i+1][j] + prefixSum0[i][j+1]-prefixSum0[i][j]+(matrix[i][j]==0?1:0);
                prefixSum1[i+1][j+1] = prefixSum1[i+1][j] + prefixSum1[i][j+1]-prefixSum1[i][j]+(matrix[i][j]==1?1:0);
            }
        }


        for (int size = 1; size <= n; size++) {
            int perfectCount = 0;
            for (int i = 0; i <= n-size; i++) {
                for (int j=0;j<=n-size;j++){
                    int count0 = prefixSum0[i+size][j+size]- prefixSum0[i][j+size]-prefixSum0[i+size][j]+prefixSum0[i][j];
                    int count1 = prefixSum1[i+size][j+size] - prefixSum1[i][j+size] - prefixSum1[i+size][j] + prefixSum1[i][j];
                    if (count0==count1){
                        perfectCount++;
                    }
                }
            }
            System.out.println(perfectCount);
        }
    }
}
