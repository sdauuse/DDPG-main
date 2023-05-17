package com.miao.algorithm.lanqiao2;

import java.util.Scanner;

public class FoodLink {
    static final int N = 100010;
    static int[] p = new int[N];
    static int[] d = new int[N];
    static int falseNumber = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        foodFind(n, k);

        System.out.println(falseNumber);
    }

    private static void foodFind(int n, int k) {
        for (int i = 0; i < k; i++) {
            int query = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x > n || y > n) {
                falseNumber++;
            } else {
                int xFather = find(x);
                int yFather = find(y);
                if (query == 1) {
                    //假话
                    if (xFather == yFather && (d[y] - d[x]) % 3 != 0) {
                        falseNumber++;

                        //真话
                        //当前不在同一集合中，无法判定为假。故为真，应加入同一集合表示存在同类关系
                    } else if (xFather != yFather) {
                        p[xFather] = yFather;
                        //(d[x]+d[xFather]-d[y])%3 = 0,由于判断时都针对mod 3,故3可省略
                        d[xFather] = d[y] - d[x];
                    }
                } else {
                    if (xFather == yFather && (d[x] - d[y] - 1) % 3 != 0) {
                        falseNumber++; //在一个集合里面，不满足x吃y的关系，那么为假话
                    } else if (xFather != yFather) {
                        p[xFather] = yFather;
                        d[xFather] = d[y] - d[x] + 1;
                    }
                }
            }
        }
    }


    public static int find(int x) {
        if (p[x] != x) {
            int u = find(p[x]);
            d[x] += d[p[x]];
            p[x] = u;
        }

        return p[x];
    }
}