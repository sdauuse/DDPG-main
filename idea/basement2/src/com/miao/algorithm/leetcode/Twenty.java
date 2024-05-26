package com.miao.algorithm.leetcode;

import java.util.Stack;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-30
 * @Copyright：
 */
public class Twenty {
    public static void main(String[] args) {
        String s = "]";
        isValid(s);
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();

        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            if (isLeft(temp)) {
                stack.push(temp);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                if (pop == '(' && temp!=')') {
                    return false;
                }else if (pop=='[' && temp!=']'){
                    return false;
                }else if (pop=='{' && temp!='}' ){
                    return false;
                }
            }
        }

        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }


    public static boolean isLeft(char c) {
        if (c == '(' || c == '[' || c == '{') {
            return true;
        } else {
            return false;
        }
    }
}
