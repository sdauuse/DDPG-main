package com.miao.algorithm.acwingunit2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Expression {
    public static Stack<Integer> nums = new Stack<>();
    public static Stack<Character> ops = new Stack<>();
    //存放优先级
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
                int temp = 0;
                int j = i;
                while (j < len && Character.isDigit(s.charAt(j))) {
                    temp = temp * 10 + s.charAt(j) - '0';
                    j++;
                }
                nums.push(temp);
                i = j - 1;
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (ops.peek() != '(') {
                    computing();
                }
                ops.pop();
            } else if (ops.isEmpty()) {
                ops.push(s.charAt(i));
            } else {
                while (!ops.isEmpty() && ops.peek() != '(' && pri.get(ops.peek()) >= pri.get(s.charAt(i))) {
                    computing();
                }
                ops.push(s.charAt(i));
            }
        }
        while (!ops.isEmpty()) {
            computing();
        }

        System.out.println(nums.peek());
    }

    private static void computing() {

        int num1 = nums.pop();
        int num2 = nums.pop();
        int sum;
        char option = ops.pop();

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
