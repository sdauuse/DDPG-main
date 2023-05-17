package com.miao.algorithm.luogu.tidanchafen;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int b = sc.nextInt();
        boolean[] blocked = new boolean[n];
        for (int i = 0; i < b; i++) {
            blocked[sc.nextInt()] = true;
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (graph.get(node).size() == 1) {  // 判断是否是叶子节点
                System.out.println(getPath(graph, node));
                return;
            }
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor] && !blocked[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println("NULL");
    }

    private static String getPath(Map<Integer, List<Integer>> graph, int end) {
        StringBuilder sb = new StringBuilder();
        int cur = end;
        while (cur != 0) {
            int parent = graph.get(cur).get(0);
            sb.append(cur).append(" ");
            cur = parent;
        }
        sb.append("0");
        return sb.reverse().toString();
    }
}
