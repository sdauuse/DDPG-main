package com.miao.algorithm.acwing1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReplaceSpace {

    public static String replaceSpaces(StringBuffer str) {

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                str.replace(i, i + 1, "%20");
            }
        }

        return str.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        StringBuffer sb = new StringBuffer(s);

        s=replaceSpaces(sb);
        System.out.println(s);
    }
}
