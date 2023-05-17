package com.miao.algorithm.dayday4;

import java.util.Scanner;

@SuppressWarnings("all")
public class LCA {
    static int N = 1010;
    static int[] l = new int[N];
    static int[] r = new int[N];

    //存储一个点的父节点
    static int[] p = new int[N];
    //存储一个点所在树上的深度，根的深度为1
    static int[] depth = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            for (int j = 1; j <= n; j++) {
                int lChild = sc.nextInt();
                int rChild = sc.nextInt();
                l[j] = lChild;
                r[j] = rChild;
                if (lChild != -1) {
                    p[lChild] = j;
                }
                if (rChild != -1) {
                    p[rChild] = j;
                }
            }

            //深度优先遍历计算左孩子的深度
            //传入根节点1号节点， 设根节点的深度为1
            dfs(1, 1);

            for (int j = 1; j <= m; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                //LCA问题的公式
                System.out.println(depth[x] + depth[y] - 2 * depth[Lca(x, y)]);
            }
        }
    }


    ////root表示根节点，len表示目前深度
    private static void dfs(int root, int len) {
        if (root == -1) {
            return;
        }
        depth[root] = len;
        //深度优先遍历计算左孩子的深度
        dfs(l[root], len + 1);
        //深度优先遍历计算右孩子的深度
        dfs(r[root], len + 1);
    }

    private static int Lca(int x, int y) {

        //如果左边的孩子x 比右边的孩子y 深度要深即要矮的时候，x就往上爬
        while (depth[x] > depth[y]) {
            x = p[x];
        }

        //如果右边的孩子y 比 左边的孩子x 深度要深即要矮的时候，y就往上爬
        while (depth[y] > depth[x]) {
            y = p[y];
        }

        //经过上面的运算，现在x和y在同一高度上了
        //当x和y不相等的时候，就一起往上爬
        while (x != y) {
            x = p[x];
            y = p[y];
        }

        //最后返回公共祖先
        return x;
    }
}
