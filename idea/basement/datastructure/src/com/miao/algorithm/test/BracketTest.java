package com.miao.algorithm.test;

import com.miao.algorithm.linear.Stack;

public class BracketTest {
    public static void main(String[] args) {
        String str = "(上海[长]{安})}";
        boolean match = isMatch(str);
        System.out.println(match);
    }

    public static boolean isMatch(String str){
        int length = str.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c=='('||c=='['||c=='{'){
                stack.push(c);
            }else if (c==')'){
                Character pop = stack.pop();
                if (pop==null){
                    return false;
                }
                if (pop!='('){
                    return false;
                }
            }else if (c==']'){
                Character pop = stack.pop();
                if (pop==null){
                    return false;
                }
                if (pop!='['){
                    return false;
                }
            }else if (c=='}'){
                Character pop = stack.pop();
                if (pop==null){
                    return false;
                }
                if (pop!='{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
