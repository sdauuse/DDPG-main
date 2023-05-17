package com.miao.algorithm.test;

import com.miao.algorithm.linear.Stack;

public class ReversePolishNotion {
    public static void main(String[] args) {
        String[] notion = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int calculate = calculate(notion);
        System.out.println(calculate);
    }

    public static int calculate(String[] notion) {
        Stack<Integer> stack = new Stack<>();

        int length = notion.length;
        Integer op1;
        Integer op2;
        Integer result;

        for (int i = 0; i < length; i++) {


            String current = notion[i];
            switch (current) {
                case "+":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    result = op1 + op2;
                    stack.push(result);
                    break;
                case "-":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    result = op2 - op1;
                    stack.push(result);
                    break;
                case "*":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    result = op2 * op1;
                    stack.push(result);
                    break;
                case "/":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    result = op2 / op1;
                    stack.push(result);
                    break;
                default:
                    stack.push(Integer.parseInt(current));
                    break;
            }

        }

        result = stack.pop();
        return result;
    }
}
