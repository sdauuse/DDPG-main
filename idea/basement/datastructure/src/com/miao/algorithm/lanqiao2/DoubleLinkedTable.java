package com.miao.algorithm.lanqiao2;

import java.util.Scanner;

public class DoubleLinkedTable {
    static final int N = 100010;
    static int[] ele = new int[N];
    static int[] l = new int[N];
    static int[] r = new int[N];

    static Scanner sc = new Scanner(System.in);

    static int idx = 1;
    static int head = 0;
    static int tail = N - 1;

    public static void main(String[] args) {
        int m = sc.nextInt();

        doubleLinked(m);
    }

    private static void doubleLinked(int m) {
        l[tail] = head;
        r[head] = tail;
        for (int i = 0; i < m; i++) {
            String op = sc.next();
            if (op.equals("L")) {
                int x = sc.nextInt();
                insertRight(head, x);
            } else if (op.equals("R")) {
                int x = sc.nextInt();
                insertRight(l[tail], x);
            } else if (op.equals("D")) {
                int k = sc.nextInt();
                delete(k);
            } else if (op.equals("IL")) {
                int k = sc.nextInt();
                int x = sc.nextInt();
                insertRight(l[k], x);
            } else if (op.equals("IR")) {
                int k = sc.nextInt();
                int x = sc.nextInt();
                insertRight(k, x);
            }
        }

        int p = r[head];
        while(p != tail){
            System.out.print(ele[p] + " ");
            p = r[p];
        }
    }

    private static void insertRight(int k, int x) {
        ele[idx] = x;
        l[idx] = k;
        r[idx] = r[k];
        l[r[k]] = idx;
        r[k] = idx;
        idx++;
    }

  /*  private static void insertLeft(int k, int x) {
        ele[idx] = x;
        l[idx] = l[k];
        r[idx] = k;
        r[l[k]] = idx;
        l[k] = idx;
        idx++;

    }*/

    private static void delete(int k) {
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }

/*    private static void mostLeft(int x) {
        ele[idx] = x;
        l[idx] = 0;
        r[idx] = head;
        head = idx;
        idx++;
    }*/

/*    private static void mostRight(int x) {
        ele[idx] = x;
        l[idx] = tail;
        r[idx] = N - 1;
        tail = idx;
        idx++;
    }*/
}
