package com.practice.programming;


public class ReverseLinkList {
    public static void main(String[] args) {

        Node node1 = new Node(3);
        Node node2 = new Node(5);
        Node node3 = new Node(6);
        Node node4 = new Node(7);
        Node node5 = new Node(8);
        // 3 -> 5 -> 6 -> 7 -> 8->9
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node rev = reverse(node1);
        printList(rev);
    }

    public static void printList(Node rev) {
        while(rev!=null) {
            System.out.printf(rev.data +" ");
            rev = rev.next;
        }
        System.out.println();
    }

    private static Node reverse(Node head) {
       Node prev, curr, nxt;
       curr = head;
       prev = null;
       while(curr != null) {
           nxt = curr.next;
           curr.next = prev;
           prev = curr;
           curr = nxt;
       }
       return prev;
    }
}
