package com.miao.algorithm.lanqiao3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BellmanFord {
    static final int N = 550;
    static final int MAX = 0x3f3f3f;
    static int[] dist = new int[N];
    static Node[] nodes = new Node[N];

    //备份dist数组
    static int[] back = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);
        for (int i = 0; i < m; i++) {
            String[] s1 = bf.readLine().split(" ");
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);
            int c = Integer.parseInt(s1[2]);
            nodes[i] = new Node(x, y, c);

        }

        bellmanFord(n, m, k);
    }

    private static void bellmanFord(int n, int m, int k) {
        Arrays.fill(dist, MAX);
        dist[1] = 0;
        for (int i = 0; i < k; i++) {
            back = Arrays.copyOf(dist, n + 1);
            for (int j = 0; j < m; j++) {
                Node node = nodes[j];
                int x = node.x;
                int y = node.y;
                int c = node.c;
                dist[y] = Math.min(dist[y], back[x] + c);
            }
        }

        if (dist[n] > MAX / 2) {
            System.out.println("impossible");
        } else {
            System.out.println(dist[n]);
        }
    }

    static class Node {
        int x;
        int y;
        int c;

        public Node(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

}
