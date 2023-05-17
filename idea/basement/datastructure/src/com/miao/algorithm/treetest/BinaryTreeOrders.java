package com.miao.algorithm.treetest;

import com.miao.algorithm.linear.Queue;
import com.miao.algorithm.tree.BinaryTree;

public class BinaryTreeOrders {
    public static void main(String[] args) {
        BinaryTree<String, String> tree = new BinaryTree<>();

        tree.put("E", "5");
        tree.put("B", "2");
        tree.put("G", "7");
        tree.put("A", "1");
        tree.put("D", "4");
        tree.put("F", "6");
        tree.put("H", "8");
        tree.put("C", "3");

        Queue<String> strings = tree.preOrder();

        for (String string : strings) {
            System.out.println(string + "\t" + tree.get(string));
        }
        System.out.println("-----------------------------");
        Queue<String> strings1 = tree.inOrder();
        for (String s : strings1) {
            System.out.println(s);
        }
    }
}
