package com.miao.algorithm.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-09
 * @Copyright：
 */
public class Six {
    public static int N = (int) (1e5 + 10);
    public static int[] p = new int[N];
    public static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        //初始化并查集
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            union(u, v);
        }
        for (int i = 0; i < q; i++) {
            int op = sc.nextInt();
            int u = sc.nextInt();
            int v = sc.nextInt();

            if (op == 1) {
                map.put(u, v);
                map.put(v,u);
            } else if (op == 2) {
                if (find(u) == find(v)) {
                    if (map.get(u)==v){
                        System.out.println("No");
                    }
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }


    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            p[rootX] = rootY;
        }
    }

    public static int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }

        return p[x];
    }
}
