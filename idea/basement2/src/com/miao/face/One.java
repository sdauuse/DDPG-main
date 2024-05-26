package com.miao.face;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-04-19
 * @Copyright：
 */
public class One {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        t.add(1);
        res.add(t);

        for (int i = 1; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                if (j == 0 || j== i-1) {
                    temp.add(1);
                } else {
                    temp.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }

            }
            res.add(temp);
        }
        res.remove(0);
        return res;
    }

}
