package com.miao.algorithm.treetest;

import com.miao.algorithm.heap.Heap;

public class HeapTest {
    public static void main(String[] args) {
        Heap<String> heap = new Heap(10);


        heap.insert("a");
        heap.insert("b");
        heap.insert("c");
        heap.insert("d");
        heap.insert("e");
        heap.insert("f");
        heap.insert("g");

        String result = null;
        while ((result = heap.delMax()) != null) {
            System.out.print(result + "\t");
        }
    }
}
