package com.miao.algorithm.leetcode;

import java.util.*;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-05-11
 * @Copyright：
 */
public class OneSeven {
    static class State {
        long value;
        long cost;

        State(long value, long cost) {
            this.value = value;
            this.cost = cost;
        }
    }

    public static long findMinCost(long x, long y, long c1, long c2, long c3) {
        // 使用优先队列以保证总是扩展代价最小的状态
        PriorityQueue<State> queue = new PriorityQueue<>(Comparator.comparingLong(s -> s.cost));
        Map<Long, Long> costMap = new HashMap<>(); // 用于记录到达每个点的最小花费

        // 初始状态
        queue.add(new State(x, 0));
        costMap.put(x, 0L);

        while (!queue.isEmpty()) {
            State current = queue.poll();

            // 如果到达y，返回当前花费
            if (current.value == y) {
                return current.cost;
            }

            // 探索所有可能的操作
            List<State> nextStates = Arrays.asList(
                    new State(current.value + 2, current.cost + c1),
                    new State(current.value - 3, current.cost + c2),
                    new State(current.value + 5, current.cost + c3)
            );

            for (State nextState : nextStates) {
                // 保证不处理负数情况
                if (nextState.value >= 0) {
                    // 如果没有记录花费或找到了更小的花费
                    if (!costMap.containsKey(nextState.value) || nextState.cost < costMap.get(nextState.value)) {
                        costMap.put(nextState.value, nextState.cost);
                        queue.add(nextState);
                    }
                }
            }
        }

        // 如果无法达到y，理论上不会发生因为题目保证有解
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 读取数据组数

        for (int i = 0; i < T; i++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            long c1 = scanner.nextLong();
            long c2 = scanner.nextLong();
            long c3 = scanner.nextLong();

            System.out.println(findMinCost(x, y, c1, c2, c3));
        }

        scanner.close();
    }
}
