package com.miao.algorithm.test;

import com.miao.algorithm.linear.LinkList;

public class FastSlowTest {
    public static void main(String[] args) {
        Node<String> first = new Node<>("aa", null);
        Node<String> second = new Node<>("bb", null);
        Node<String> third = new Node<>("cc", null);
        Node<String> fourth = new Node<>("ddd", null);
        Node<String> fifth = new Node<>("ee", null);
        Node<String> sixth = new Node<>("ff", null);


        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;

        sixth.next = third;

        //String mid = getMid(first);
        //System.out.println(mid);
        //isCircle(first);
        getEntrance(first);
    }

    //判断是否有环
    public static boolean isCircle(Node<String> first) {
        Node<String> fast = first;
        Node<String> slow = first;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                System.out.println("有环");
                return true;
            }
        }

        System.out.println("无环");
        return false;
    }

    //判断环在哪里
    public static Node getEntrance(Node<String> first) {
        Node<String> fast = first;
        Node<String> slow = first;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                Node<String> temp = first;
                while (slow != temp) {
                    slow = slow.next;
                    temp = temp.next;
                }

                System.out.println("有环，环在" + temp.item);
                return temp;
            }
        }

        System.out.println("无环");
        return null;
    }


    public static String getMid(Node<String> first) {

        Node<String> fast = first;
        Node<String> slow = first;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.item;
    }

    private static class Node<T> {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
