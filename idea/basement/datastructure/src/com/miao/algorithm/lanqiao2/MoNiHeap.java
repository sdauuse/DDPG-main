package com.miao.algorithm.lanqiao2;

import java.util.Scanner;

/**
 * ph[k] 保存的是第k个插入的数的下标
 * hp[k] 保存的是堆中下标是k的点是第几个插入的
 */
@SuppressWarnings("all")
public class MoNiHeap {
    static final int N = 100010;
    static int[] h = new int[N];
    //ph[k] 保存的是第k个插入的数的下标
    static int[] ph = new int[N];
    //hp[k] 保存的是堆中下标是k的点是第几个插入的
    static int[] hp = new int[N];
    static int idx = 0;
    static int m = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        ops(n);
    }

    private static void ops(int n) {
        for (int i = 0; i < n; i++) {
            String query = sc.next();

            if (query.equals("I")) {
                int x = sc.nextInt();
                idx++;
                m++;
                ph[m] = idx;
                hp[idx] = m;
                h[idx] = x;
                up();
            } else if (query.equals("PM")) {
                System.out.println(h[1]);
            } else if (query.equals("DM")) {
                pop();
            } else if (query.equals("D")) {
                int k = sc.nextInt();
                k = ph[k];//ph[k] 是一步一步插入映射的下标，不会乱序，
                head_swap(k, idx);//然后将k与最后一个元素进行交换，然后长度减1，size--
                idx--;
                up(k);//进行排序一遍，为了省代码量，up一遍down一遍。因为只会执行其中一个
                down(k);
            } else {
                int k = sc.nextInt();
                int x = sc.nextInt();
                k = ph[k];//ph[k] 是一步一步插入映射的下标，顺序是按照插入时候的顺序
                h[k] = x;//然后将第k为数修改为数x
                up(k);//up一遍，down一遍
                down(k);
            }
        }
    }

    public static void head_swap(int x, int y) {
        //这里因为映射数组跟被映射数组是互相指向对方,如果有两个数更换位置，映射下标也要进行更换
        //ph的下标指向是按顺序插入的下标，hp所对应的值是ph的按顺序的下标，用这两个属性进行交换
        swap(ph, hp[x], hp[y]);
        //因为按照顺序插入ph到指向交换了，对应指向ph的hp也要进行交换
        swap(hp, x, y);
        //最后两个值进行交换
        swap(h, x, y);
    }

    private static void del(int x) {

    }

    private static void pop() {
        head_swap(1, idx);
        idx--;
        down(1);
    }

    private static void down(int i) {
        int in = i;
        int left = 2 * in;
        int right = 2 * in + 1;

        if (left <= idx && h[left] < h[in]) {
            in = left;
        }
        if (right <= idx && h[right] < h[in]) {
            in = right;
        }

        if (i != in) {
            head_swap(i, in);
            down(in);
        }
    }

    public static void up(int x) {
        while (x / 2 > 0 && h[x / 2] > h[x]) {
            head_swap(x, x / 2);
            x = x / 2;//相当于一直up
        }
    }

    private static void up() {
        int n = idx;
        int father = n / 2;
        while (father > 0 && h[father] > h[n]) {
            head_swap(father, n);
            n = father;
            father = n / 2;
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
