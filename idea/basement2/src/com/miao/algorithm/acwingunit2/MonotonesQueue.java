package com.miao.algorithm.acwingunit2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class MonotonesQueue {
    public static Deque<Integer> queue = new LinkedList<>();
    public static int N = (int) (1e6 + 10);
    public static int[] a = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        String[] s1 = bf.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(s1[i - 1]);
        }

        for (int i = 1; i <= n; i++) {
            while (!queue.isEmpty() && queue.getLast() > a[i]) {
                queue.removeLast();
            }
            queue.addLast(a[i]);
            //前面一个条件是判断滑动窗口是否已经形成
            //第二个条件判断队列头的元素是否已经超过了滑动窗口的范围
            if (i - k >= 1 && queue.getFirst() == a[i - k]) {
                queue.removeFirst();
            }
            if (i >= k) {
                System.out.print(queue.getFirst()+" ");
            }
        }
        queue.clear();
        System.out.println();
        for (int i = 1; i <= n; i++) {
            while (queue.size() != 0 && queue.getLast() < a[i]) {
                queue.removeLast();
            }
            queue.addLast(a[i]);
            if (i - k >= 1 && queue.getFirst() == a[i - k]) {
                queue.removeFirst();
            }
            if (i >= k) {
                System.out.print(queue.getFirst() + " ");
            }
        }
    }
}
