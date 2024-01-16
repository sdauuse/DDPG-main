package com.miao.algorithm.acwingunit1;

import java.util.*;

public class IntervalMerging {

    public static void main(String[] args) {

        List<PII> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            list.add(new PII(l, r));
        }

        Collections.sort(list);
        merge(list);
    }

    private static void merge(List<PII> list) {
        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;
        List<PII> res = new ArrayList<>();
        for (PII pii : list) {
            int l = pii.l;
            int r = pii.r;

            if (end >= l) {
                end = Math.max(end, r);
            } else {
                start = l;
                end = r;
                res.add(new PII(start, end));
            }
        }

        System.out.println(res.size());
    }

    private static class PII implements Comparable<PII> {
        int l;
        int r;

        public PII(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(PII o) {
            return Integer.compare(l, o.l);
        }
    }
}
