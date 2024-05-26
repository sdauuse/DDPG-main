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
public class Two2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = bf.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        String s = bf.readLine();
//        Scanner sc = new Scanner(System.in);
//
//
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        sc.nextLine();
//        String s = sc.nextLine();
        String res = reverseInPart(s, k);
        System.out.println(res);
    }

    private static String reverseInPart(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i += k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1);
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        return new String(chars);
    }
}
