package com.miao.algorithm.mihayou;

import java.util.Scanner;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-17
 * @Copyright：
 */
public class One {
    public static int N = (int) (1e5 + 10);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] h = new int[N];
        for (int i = 0; i < t; i++) {
            //怪物数量
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                h[j] = sc.nextInt();
            }
            //E伤害
            int E = sc.nextInt();
            //R伤害
            int R = sc.nextInt();

            int cntE = 0;
            int cntR = 0;

           while (true){
               boolean allDead = true;
               int triR = 0;

               cntE++;
               for (int i1 = 0; i1 < n; i1++) {

               }
           }
        }
    }
}
