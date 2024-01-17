package com.miao.algorithm.acwingunit2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MonotoneStack {
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] s = bf.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            int x = Integer.parseInt(s[i]);

            while (!stack.isEmpty() && stack.peek() >= x) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(stack.peek() + " ");
            }

            stack.push(x);
        }
    }
}
