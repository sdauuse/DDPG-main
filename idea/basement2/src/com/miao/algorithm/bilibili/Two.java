package com.miao.algorithm.bilibili;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-04-20
 * @Copyright：
 */
public class Two {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        String[] s1 = bf.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        String s = bf.readLine();

        String res = reverseString(n, k, s);
        System.out.println(res);
    }

    private static String reverseString(int n, int k, String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i <= n - k; i++) {
            reverseSubstring(sb,i,i+k-1);
        }
        return sb.toString();
    }

    private static void reverseSubstring(StringBuilder sb, int start, int end) {
        while (start < end){
            char temp = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
