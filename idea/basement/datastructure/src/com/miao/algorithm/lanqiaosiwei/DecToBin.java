package com.miao.algorithm.lanqiaosiwei;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecToBin {


    public static void main(String[] args) {

        toBinary(8);
    }


    public static void toBinary(int x) {
        List<Integer> list = new ArrayList<>();
        while (x != 0) {
            if ((x & 1) == 1) {
                list.add(1);
            } else {
                list.add(0);
            }
            x = x >> 1;
        }

        for (int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i));
        }
    }
}