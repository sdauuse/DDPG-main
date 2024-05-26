package com.miao.algorithm.leetcode;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-25
 * @Copyright：
 */
public class TwoOne {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode cur = res;
        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                cur = list1;
                list1 = list1.next;
            } else {
                cur = list2;
                list2 = list2.next;
            }
            cur = cur.next;

        }
        if (list1 != null) {
            cur.next = list1;
        } else if (list2 != null) {
            cur.next = list2;
        }

        return res.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
