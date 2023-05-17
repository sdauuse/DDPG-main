package com.miao.algorithm.dayday3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CatClimbMountain {
    static final int N = 20;
    static Integer[] C = new Integer[N];
    static int[] cab = new int[N];
    static boolean[] visited = new boolean[N];
    static int n;
    static int w;
    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        w = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            C[i] = sc.nextInt();
        }

        //从大到小排序
        Arrays.sort(C, 1, n + 1, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (int) o2 - (int) o1;
            }
        });
        res = n;
        //u=1表示第一只猫， cnt表示当前租了多少俩车，cnt=0表示还没有租车
        dfs(1, 0);

        System.out.println(res);
    }

    private static void dfs(int u, int cnt) {

        //如果当前车的数量已经大于等于以前的结果，那么就不用执行下去了
        if (cnt >= res) {
            return;
        }

        if (u == n + 1) {
            res = Math.min(res, cnt);
            return;
        }

        //尝试分配到已经租用的缆车上
        for (int i = 1; i <= cnt; i++) {

            if (cab[i] + C[u] <= w) {
                cab[i] += C[u];
                dfs(u + 1, cnt);
                cab[i] -= C[u];
            }
        }

        //开一辆新的车
        cab[cnt + 1] = C[u];
        dfs(u + 1, cnt + 1);
        cab[cnt + 1] = 0;

    }
}
