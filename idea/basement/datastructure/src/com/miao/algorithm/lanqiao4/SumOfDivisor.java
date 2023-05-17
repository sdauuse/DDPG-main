package com.miao.algorithm.lanqiao4;

import java.util.*;

public class SumOfDivisor {

    static final int mod = (int) (1e9 + 7);

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        int n = scan.nextInt();
        while (n-- > 0) {
            int x = scan.nextInt();
            for (int i = 2; i <= x / i; i++) {
                while (x % i == 0) {
                    x /= i;
                    map.put(i, map.getOrDefault(i, 0) + 1);
                }
            }
            if (x > 1) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }
        long res = 1;
        for (int a : map.keySet()) {
            int b = map.get(a);
            long t = 1;
            //这里为什么是t * a + 1,后面的一是我们将没有将t等于0，所以我们自己将a的0次方写成1，方便代码表达
            while (b-- > 0) {
                t = (t * a + 1) % mod;
            }
            // p = a ^ 3 * b ^ 1;
            // sum = (a ^ 0 + a ^ 1 + a ^ 2 + a ^ 3) * (b ^ 0 + b ^ 1)
            // 这个结果就是我们想要求得约数之和
            res = res * t % mod;
        }
        System.out.println(res);
    }

}

