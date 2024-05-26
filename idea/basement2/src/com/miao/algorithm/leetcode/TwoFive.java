package com.miao.algorithm.leetcode;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-04-15
 * @Copyright：
 */
public class TwoFive {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(5);

        reverseKGroup(head, 2);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode slow = pre;
        ListNode fast = pre;
        while (fast != null) {
            for (int i = 0; i < k && fast != null; i++) {
                fast = fast.next;
            }
            if (fast == null) {
                break;
            }
            ListNode start = slow;
            ListNode end = slow.next;

            while (end != fast) {
                ListNode temp = end;
                end = end.next;
                temp.next = start.next;
                start.next = temp;
            }
        }

        return head;
    }
}
