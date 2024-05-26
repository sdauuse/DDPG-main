package com.miao.algorithm.leetcode;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-04-04
 * @Copyright：
 */
public class TwoThreeFour {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode temp = listNode;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(1);

        isPalindrome(listNode);

    }

    static int N = (int) 1e5 + 10;

    public static boolean isPalindrome(ListNode head) {
        int[] arr = new int[N];
        int l = 0;
        int r = 0;
        while (head != null) {
            arr[r] = head.val;
            r++;
            head = head.next;
        }
        r--;
        while (l <= r) {

            if (arr[l] != arr[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
