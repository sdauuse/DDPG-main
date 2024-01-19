package com.miao.algorithm.acwingunit2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-01-19
 * @Copyright：
 */
public class SimHash {
    private static int N = 200003;
    private static int nullNum = 0x3f3f3f;
    private static int[] ht = new int[N];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arrays.fill(ht, nullNum);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String op = sc.next();
            int x = sc.nextInt();
            if (op.equals("I")) {
                int pos = hash(x);
                ht[pos] = x;
            } else if (op.equals("Q")) {
                int pos = hash(x);
                if (ht[pos]==x){
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }
        }
    }

    public static int hash(int x) {
        int pos = (x % N + N) % N;
        while (ht[pos] != nullNum && ht[pos] != x) {
            pos++;
            if (pos == N) {
                pos = 0;
            }
        }

        return pos;
    }
}
