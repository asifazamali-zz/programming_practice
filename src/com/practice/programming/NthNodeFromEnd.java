package com.practice.programming;

public class NthNodeFromEnd {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        //1-> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;


        int n = 9;

        System.out.println(getNthNodeFromEnd(node1, n));
    }

    private static int getNthNodeFromEnd(Node node1, int n) {
        Node slow, fast;
        slow = fast = node1;
        while(--n > 0 && fast != null) {
            fast = fast.next;

        }
        if(fast == null) {
            return -1;
        }
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }
}
