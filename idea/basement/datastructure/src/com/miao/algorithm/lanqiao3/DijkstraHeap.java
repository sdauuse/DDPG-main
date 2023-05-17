package com.miao.algorithm.lanqiao3;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraHeap {
    static final int N = 150010;
    static int idx = 0;
    static final int MAX = 0x3f3f3f;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] w = new int[N];
    static int[] dist = new int[N];
    static boolean[] visited = new boolean[N];
    static PriorityQueue<int[]> pq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Arrays.fill(h, -1);
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int c = sc.nextInt();
            add(x, y, c);
        }

        int res = dijkstra(n);
        System.out.println(res);
    }
    private static int dijkstra (int n){


        Arrays.fill(dist,MAX);
        pq.offer(new int []{1, 0}) ;
        dist[1] = 0 ;
        while (!pq.isEmpty()) {
            int [] cur = pq.poll();
            int ver = cur[0] ;
            int distance = cur[1] ;
            if (visited[ver]){
                continue ;
            }
            visited[ver] = true;
            for (int i = h[ver]; i != -1; i = ne[i]){
                int j = e[i];
                if (dist[j] > distance + w[i]){
                    dist[j] = distance + w[i];
                    pq.offer(new int [] {j, dist[j]});
                }
            }
        }
        return dist[n] == MAX ? -1 : dist[n];
    }

    public static void add(int x, int y, int c) {
        e[idx] = y;
        w[idx] = c;
        ne[idx] = h[x];
        h[x] = idx++;
    }

}

