package com.miao.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-04-13
 * @Copyright：
 */
public class OneZeroOne {
    public static void main(String[] args) {

        TreeNode root = new TreeNode();
        TreeNode temp = root;
        //[1,2,2,null,3,null,3]
        root.val = 1;
        temp.left = new TreeNode(2);
        temp.right = new TreeNode(2);
        temp = temp.left;
        temp.left = null;
        temp.right = new TreeNode(3);
        temp = root.right;
        temp.left = null;
        temp.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        boolean res = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size;
        StringBuilder sb;
        while (!q.isEmpty()) {
            size = q.size();
            sb = new StringBuilder();
            while (size-- > 0) {
                TreeNode t = q.poll();
                if (t==null){
                    sb.append("-1");
                    continue;
                }
                if (t.left != null || t.right != null) {
                    q.add(t.left);
                    q.add(t.right);
                }
                int temp = t.val;
                sb.append(temp);
            }

            String s = sb.toString();
            String s2 = String.valueOf(sb.reverse());
            if (!s.equals(s2)) {
                return false;
            }
        }
        return res;
    }
}
