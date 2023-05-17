package com.miao.algorithm.acwingcup;

import java.util.Scanner;

public class First {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();


        int res = 0;
        for (int i = 0; x != 0; i++, x >>= 1){
            if ((x&1)==1){
                res += 1;
            }
        }

        System.out.println(res);
    }
}
