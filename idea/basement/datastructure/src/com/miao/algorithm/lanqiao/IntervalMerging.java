package com.miao.algorithm.lanqiao;

import java.util.*;

public class IntervalMerging {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<PII> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.add(new PII(x, y));
        }

        Collections.sort(list);

        merging(list);

    }

    private static void merging(List<PII> list) {
        List<PII> res = new ArrayList<>();
        int start = (int) -2e9;
        int end = (int) -2e9;
        for (PII item : list) {
            if (end < item.x) {
                if (end != (int) -2e9) {
                    res.add(new PII(start, end));
                }
                start = item.x;
                end = item.y;
            } else {
                end = Math.max(end, item.y);
            }
        }

        if (end != (int) -2e9) {
            res.add(new PII(start, end));
        }
        System.out.println(res.size());
    }


    private static class PII implements Comparable<PII> {

        int x;
        int y;

        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(PII o) {
            return Integer.compare(x, o.x);
        }

    }
}
