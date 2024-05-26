package com.miao.algorithm.leetcode;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-28
 * @Copyright：
 */
public class Two {
    //l1 = [2,4,3], l2 = [5,6,4]
    //输出：[7,0,8]
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode temp = l1;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        ListNode t = l2;
        t.next = new ListNode(6);
        t = t.next;
        t.next = new ListNode(4);

        ListNode res = addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode();
        ListNode head = res;
        while (l1 != null || l2 != null || carry != 0) {
            head.next = new ListNode();
            head = head.next;
            int up = l1 == null ? 0 : l1.val;
            int down = l2 == null ? 0 : l2.val;
            int temp = carry + up + down;
            head.val = temp % 10;

            carry = temp / 10;
            if (l1!=null){
                l1 = l1.next;
            }
            if (l2!=null){
                l2 = l2.next;
            }
        }

        return res.next;
    }
}

class ListNode2 {
    int val;
    ListNode2 next;

    public ListNode2() {

    }

    public ListNode2(int val) {
        this.val = val;
    }

    public ListNode2(int val, ListNode2 next) {
        this.val = val;
        this.next = next;
    }
}
