package com.miao.algorithm.heap;

public class Heap<T extends Comparable<T>> {

    private T[] items;
    private int N;

    public Heap(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    private void exchange(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    //堆上浮算法
    private void swim(int k) {
        int father = k / 2;

        while (father >= 1 && less(father, k)) {
            exchange(k, father);
            k = father;
            father = k / 2;
        }
    }

    public T delMax() {
        T max = items[1];

        exchange(1, N);

        items[N] = null;
        N--;

        sink(1);

        return max;
    }

    //堆下沉算法
    private void sink(int k) {

        while (N >= 2 * k) {
            int max;
            if (2 * k + 1 <= N) {
                if (less(2 * k, 2 * k + 1)) {
                    max = 2 * k + 1;
                } else {
                    max = 2 * k;
                }
            } else {
                max = 2 * k;
            }

            if (!less(k, max)) {
                break;
            }

            exchange(k, max);
            k = max;
        }
    }

}
