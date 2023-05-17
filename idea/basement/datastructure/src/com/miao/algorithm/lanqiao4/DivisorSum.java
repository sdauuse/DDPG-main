package com.miao.algorithm.lanqiao4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DivisorSum {
    static final int m = (int) (1e9 + 7);

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();

            for (int j = 2; j <= x / j; j++) {
                while (x % j == 0) {
                    x = x / j;
                    map.put(j, map.getOrDefault(j, 0) + 1);
                }
            }

            if (x > 1) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }

        long res = 1;
        //map.keySet()获取所有的key值,map.values()获取所有的values值，两种方法都可以
        for(int value : map.values()){
            res = res * (value + 1) % m;
        }
        System.out.println(res);
    }
}
