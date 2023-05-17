package com.miao.algorithm.treetest;

import com.miao.algorithm.tree.BinaryTree;

public class BinaryTreeTest {
    public static void main(String[] args) {

        BinaryTree<Integer, String> tree = new BinaryTree<>();

        tree.put(1, "小一");
        tree.put(2, "小二");
        tree.put(3, "小三");
        System.out.println("插入完毕后元素个数" + tree.size());

        System.out.println(tree.get(2));

        //tree.delete(1);
        System.out.println(tree.size());
        System.out.println(tree.getMax());


        System.out.println(tree.maxDepth());
    }
}
