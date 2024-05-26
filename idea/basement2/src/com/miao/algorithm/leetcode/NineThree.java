package com.miao.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-30
 * @Copyright：
 */
@SuppressWarnings("all")
public class NineThree {
    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
    }


    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        search(s, 1, "", res);
        return res;
    }

    private static void search(String s, int n, String ipAddr, List<String> res) {

        if (n == 5 && s.length() == 0) {
            res.add(ipAddr.substring(0, ipAddr.length() - 1));
        }

        if (n > 5) {
            return;
        }

        int remain = 5 - n;
        if (s.length() < remain || s.length() > (3 * remain)) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (s.length() < i) {
                return;
            }

            String part = s.substring(0, i);
            int num = Integer.valueOf(part);
            if (num > 255) {
                return;
            }

            search(s.substring(i), n + 1, ipAddr + num + ".", res);
        }


       /* if (n == 5 && s.length() == 0) {
            res.add(ipAddr.substring(0, ipAddr.length() - 1));
            return;
        }

        if (n > 5) {
            return;
        }
        int remain = 5 - n;
        if (s.length() < remain || s.length() > (remain * 3)) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (s.length() < i) {
                return;
            }

            String part = s.substring(0, i);
            int num = Integer.valueOf(part);
            if (part.length() != String.valueOf(num).length()) {
                return;
            }

            if (num > 255) {
                return;
            }
            search(s.substring(i), n + 1, ipAddr + part + ".", res);
        }*/

    }
}
