package com.miao.algorithm.test;

public class JosephTest {

    public static void main(String[] args) {
        Node<Integer> first = null;
        Node<Integer> last = null;

        for (int i = 1; i <= 41; i++) {
            if (i == 1) {
                first = new Node<>(i, null);
                last = first;
                continue;
            }

            Node<Integer> newNode = new Node<>(i, null);
            last.next = newNode;
            last = newNode;

            if (i == 41) {
                last.next = first;
            }
        }

        int count = 0;
        Node<Integer> n = first;
        Node<Integer> before = null;
        while (n != n.next) {
            count++;
            if (count == 3) {
                System.out.print(n.item + ", ");
                before.next = n.next;
                n = n.next;
                count = 0;
                continue;
            }
            before = n;
            n = n.next;


        }

        System.out.println(n.item);

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
