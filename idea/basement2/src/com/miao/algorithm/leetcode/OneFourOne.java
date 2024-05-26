package com.miao.algorithm.leetcode;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-28
 * @Copyright：
 */
public class OneFourOne {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean res = false;
        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {

                return true;
            }
        }

        return res;
    }
}

class ListNode3 {
    public int val;
    public ListNode3 next;

    public ListNode3() {

    }

    public ListNode3(int val) {
        this.val = val;
    }

    public ListNode3(int val, ListNode3 next) {
        this.next = next;
    }
}
