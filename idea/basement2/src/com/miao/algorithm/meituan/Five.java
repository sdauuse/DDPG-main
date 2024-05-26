package com.miao.algorithm.meituan;

import java.util.*;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-09
 * @Copyright：
 */
public class Five {
    public static Map<Integer, Set<Integer>> graph = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.computeIfAbsent(u, k -> new HashSet<>()).add(v);
            graph.computeIfAbsent(v, k -> new HashSet<>()).add(u);
        }

        for (int i = 0; i < q; i++) {
            int op = sc.nextInt();
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (op == 1) {
                if (graph.containsKey(u)) {
                    graph.get(u).remove(v);
                }

                if (graph.containsKey(v)) {
                    graph.get(v).remove(u);
                }
            } else if (op == 2) {
                if (checkFriendship(u,v,new HashSet<>())){
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }
        }
    }

    public static boolean checkFriendship(int u, int v, Set<Integer> visited) {
        if (!graph.containsKey(u)){
            return false;
        }
        if (graph.get(u).contains(v)){
            return true;
        }
        visited.add(u);
        for (Integer neighbor : graph.get(u)) {
            if (!visited.contains(neighbor) && checkFriendship(neighbor,v,visited)){
                return  true;
            }
        }
        return false;
    }
}
