package com.miao.algorithm.lanqiao3;

import java.util.Arrays;
import java.util.Scanner;

public class BinaryDivGraph {

    static int N = 100010;
    static int idx = 0;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    //保存各个点的颜色，0 未染色，1 是红色，2 是黑色
    static int[] color = new int[N];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Arrays.fill(h, -1);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a, b);
            add(b, a);
        }

        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                if (!dfs(i, 1)) {
                    System.out.println("No");
                    return;
                }
            }
        }


        System.out.println("Yes");
    }

    private static boolean dfs(int u, int c) {

        //u的点成 c 染色
        color[u] = c;

        for (int i = h[u]; i != -1; i = ne[i]) {
            int x = e[i];
            //相邻的点没有颜色,则递归处理这个相邻点
            if (color[x] == 0) {
                //（3 - 1 = 2， 如果 u 的颜色是1，则和 u 相邻的染成 2）
                //（3 - 2 = 1， 如果 u 的颜色是2，则和 u 相邻的染成 1）
                if (!dfs(x, 3 - c)) {
                    return false;
                }
                //如果已经染色，判断颜色是否为 3 - c
            } else if (color[x] != 0 && color[x] != 3 - c) {
                return false;
            }
        }

        return true;
    }

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
