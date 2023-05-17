package com.miao.algorithm.lanqiao3;

import java.util.Scanner;

@SuppressWarnings("all")
public class TreeCore {

    //存储无向图
    static final int N = 200010;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] next = new int[N];
    static boolean[] visited = new boolean[N];
    static int idx = 0;
    static int n = 0;
    static int ans = N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            h[i] = -1;
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            //无向图，需要存两个方向
            add(a, b);
            add(b, a);
        }

        //因为是无向图，可以从任意一个几点开始搜索
        dfs(1);
        System.out.println(ans);
    }

    //返回以u为跟的子树中点的数量
    private static int dfs(int u) {
        int res = 0; //存储 删掉某个节点之后，最大的连通子图节点数
        visited[u] = true; //标记访问过u节点
        int sum = 1; //存储 以u为根的树 的节点数, 包括u，如图中的4号节点

        for (int i = h[u]; i != -1; i = next[i]) {
            int j = e[i];
            if (!visited[j]) {

                int sub = dfs(j);
                sum = sum + sub;
                res = Math.max(res, sub);
            }
        }

        res = Math.max(sum, n - sum);
        ans = Math.min(ans, res);
        return sum;
       /* //访问u的每个子节点
        for (int i = h[u]; i != -1; i = next[i]) {
            int j = e[i];
            //因为每个节点的编号都是不一样的，所以 用编号为下标 来标记是否被访问过
            if (!visited[j]) {
                int s = dfs(j);  // u节点的单棵子树节点数 如图中的size值
                res = Math.max(res, s); // 记录最大联通子图的节点数
                sum += s; //以j为根的树 的节点数
            }
        }

        //n-sum 如图中的n-size值，不包括根节点4；
        res = Math.max(res, n - sum); // 选择u节点为重心，最大的 连通子图节点数
        ans = Math.min(res, ans); //遍历过的假设重心中，最小的最大联通子图的 节点数
        return sum;*/

    }

    public static void add(int a, int b) {
        e[idx] = b;
        next[idx] = h[a];
        h[a] = idx++;
    }


}
