package com.miao.algorithm.mihayou;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-22
 * @Copyright：
 */
public class A {
    public static void main(String[] args) {
        System.out.println(addStrings("456", "77"));
    }

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int temp = x + y + carry;
            ans.append(temp % 10);
            carry = temp / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        return ans.reverse().toString();
    }
}
