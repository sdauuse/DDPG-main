package com.miao.algorithm.leetcode;

import java.util.*;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-04-05
 * @Copyright：
 */
public class OneZeroThree {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(3);
        TreeNode temp = treeNode;
        temp.left = new TreeNode(9);
        temp.right = new TreeNode(20);
        temp = temp.right;
        temp.left = new TreeNode(15);
        temp.right = new TreeNode(7);

        System.out.println(zigzagLevelOrder(treeNode));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        boolean flag = false;
        if (root != null) {
            deque.addFirst(root);
        }

        while (!deque.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = deque.size();
            if (!flag) {
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = deque.pollFirst();
                    temp.add(treeNode.val);
                    if (treeNode.left != null) {
                        deque.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        deque.add(treeNode.right);
                    }

                }

                flag = true;
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = deque.pollLast();
                    temp.add(treeNode.val);

                    if (treeNode.right != null) {
                        deque.addFirst(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        deque.addFirst(treeNode.left);
                    }

                }
                flag = false;
            }

            res.add(temp);
        }

        return res;
    }
}
