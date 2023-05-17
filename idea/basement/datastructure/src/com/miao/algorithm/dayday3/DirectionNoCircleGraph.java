package com.miao.algorithm.dayday3;

import java.io.*;
import java.util.Arrays;

public class DirectionNoCircleGraph {
    static int N = (int) 2e5 + 10;
    //  邻接表存图
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] h = new int[N];
    //  存无向边
    static Edge[] edges = new Edge[N];
    //  存某点的入度
    static int[] d = new int[N];
    //  队列便于拓扑排序
    static int[] q = new int[N];
    static int[] pos = new int[N];
    static int idx, n, m, cnt;

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Edge {
        int a;
        int b;

        public Edge(int a, int b) {
            super();
            this.a = a;
            this.b = b;
        }

    }

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static boolean topSort() {
        int hh = 0;
        int tt = -1;

         //队列存入度为 0 的点
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0){
                q[++tt] = i;
            }
        }

        while (hh <= tt) {
            int t = q[hh++];
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                d[j]--;
                if (d[j] == 0) {
                    q[++tt] = j;
                }
            }
        }
        //当 tt == n-1 时，所有数入队，即存在拓扑排序，否则就是并存在有向无环图
        return tt == n - 1;
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String[] split = in.readLine().split(" ");
            n = Integer.parseInt(split[0]);
            m = Integer.parseInt(split[1]);

            Arrays.fill(h, 0, n + 1, -1);
            Arrays.fill(d, 0, n + 1, 0);
            idx = 0;
            cnt = 0;

            for (int i = 0; i < m; i++) {
                String[] split2 = in.readLine().split(" ");
                int t = Integer.parseInt(split2[0]);
                int a = Integer.parseInt(split2[1]);
                int b = Integer.parseInt(split2[2]);
                if (t == 0) {
                    edges[cnt++] = new Edge(a, b);
                } else {
                    add(a, b);
                    d[b]++;
                }
            }

            if (!topSort()) {
                out.write("NO\n");
            } else {
                out.write("YES\n");
                // 枚举每个点
                for (int i = 1; i <= n; i++) {
                    // 枚举每个点的有向边
                    for (int j = h[i]; j != -1; j = ne[j]) {

                        out.write(i + " " + e[j] + "\n");
                    }
                }

                //枚举无向边转换成的有向边
                for (int i = 0; i < n; i++) {
                    // pos 存的就是 某点 在 队列里的下标
                    pos[q[i]] = i;
                }
                for (int i = 0; i < cnt; i++) {
                    //a b 是无向边的两个点
                    int a = edges[i].a;
                    int b = edges[i].b;
                    //根据两个点的值取出在 队列 q 的下标，下标小意味着先入队的
                    //下标小的在前面
                    if (pos[a] > pos[b]) {
                        int tmp = a;
                        a = b;
                        b = tmp;
                    }
                    out.write(a + " " + b + "\n");
                }
            }

            out.flush();
        }

    }

}
