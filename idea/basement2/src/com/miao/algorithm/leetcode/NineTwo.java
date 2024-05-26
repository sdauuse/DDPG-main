package com.miao.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-28
 * @Copyright：
 */
public class NineTwo {
    public static void main(String[] args) {

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        ListNode res = new ListNode();
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        for (int i = left - 1, j = right - 1; i < j; i++, j--) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }


        temp = res;
        for (int i = 0; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }

        return res.next;
    }
}
