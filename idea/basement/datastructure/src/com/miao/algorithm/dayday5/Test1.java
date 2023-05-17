package com.miao.algorithm.dayday5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Test1 {
    static int N = 510;
    static long[][] a = new long[N][N];
    static long[][] sum = new long[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        Map<String, Integer> map = new TreeMap<>();


        /*
         * for (int i = 0; i < s.length(); i++) { String temp = s.charAt(i) + "";
         * map.put(temp, map.getOrDefault(temp, 0) + 1); }
         *
         * for (String key : map.keySet()) { System.out.println(key + " " +
         * map.get(key)); }
         */

    }
}
