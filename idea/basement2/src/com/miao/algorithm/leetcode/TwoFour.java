package com.miao.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-04-22
 * @Copyright：
 */
public class TwoFour {

    public static void main(String[] args) {
       ListNode head = new ListNode(1);
       ListNode temp = head;
       temp.next = new ListNode(4);
       temp = temp.next;
       temp.next = new ListNode(3);

       sortList(head);
    }

    public static ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            list.add(head.val);
            temp = temp.next;
        }
        Collections.sort(list);
        temp = head;
        for(int i=0; i < list.size(); i++){
            temp.val = list.get(i);
            temp = temp.next;
        }

        return head;
    }
}
