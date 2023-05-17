package com.miao.algorithm.lanqiao2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExpressionEvaluation {
    static Stack<Integer> nums = new Stack<>();
    static Stack<Character> op = new Stack<>();
    static Map<Character, Integer> pri = new HashMap<>();

    public static void main(String[] args) throws IOException {
        pri.put('+', 1);
        pri.put('-', 1);
        pri.put('*', 2);
        pri.put('/', 2);

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();

        eval(s);
    }

    private static void eval(String s) {
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int x = 0, j = i;
                while (j < len && Character.isDigit(s.charAt(j))) {
                    x = x * 10 + s.charAt(j++) - '0';
                }
                nums.push(x);
                i = j - 1;
            } else if (c == '(') {
                op.push(s.charAt(i));
            } else if (c == ')') {
                while (op.peek() != '(') {
                    computing();
                }
                op.pop();
            } else if (op.isEmpty()) {
                op.push(s.charAt(i));
            } else {
                while (!op.isEmpty() && op.peek() != '(' && pri.get(op.peek()) >= pri.get(s.charAt(i))) {
                    computing();
                }
                op.push(s.charAt(i));
            }
        }

        while (!op.isEmpty()) {
            computing();
        }


        System.out.println(nums.peek());
    }

    private static void computing() {

        int num1 = nums.pop();
        int num2 = nums.pop();
        int sum;
        char option = op.pop();

        if (option == '+') {
            sum = num2 + num1;
            nums.push(sum);
        } else if (option == '-') {
            sum = num2 - num1;
            nums.push(sum);
        } else if (option == '*') {
            sum = num2 * num1;
            nums.push(sum);
        } else if (option == '/') {
            sum = num2 / num1;
            nums.push(sum);
        }

    }
}
