package com.miao.algorithm.lanqiao2;


import java.util.Scanner;
import java.util.Stack;

public class SingleStack {
    static Stack<Integer> stack = new Stack<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        singleStack(n);
    }

    private static void singleStack(int n) {
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();

            while (!stack.isEmpty() && x < stack.peek()) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                System.out.print("-1" + " ");
            } else {
                System.out.print(stack.peek() + " ");
            }

            stack.push(x);
        }

    }
}
