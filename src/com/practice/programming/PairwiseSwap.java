package com.practice.programming;

public class PairwiseSwap {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        Node node4 = new Node(6);
        Node node5 = new Node(9);
        Node node6 = new Node(6);
        Node node7 = new Node(11);
        Node node8 = new Node(12);
        Node node9 = new Node(13);
        //1-> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        Node newHead = null;
        ReverseLinkList.printList(node1);
        Node head = pairwiseSwap(node1);
        ReverseLinkList.printList(head);
    }

    private static Node pairwiseSwap(Node head) {
        if(head == null) return null;
        Node curr, next, nxt;
        curr = head;
        next = curr.next;
        if(next == null) return  head;
        nxt = next.next;
//        ReverseLinkList.printList(head);
        head = reverseSwap(curr, nxt);
//        ReverseLinkList.printList(head);
        curr.next = pairwiseSwap(nxt);

        return  head;

    }
    private  static Node reverseSwap(Node head, Node next) {
        Node prev, curr, nxt;
        prev = null;
        curr = head;
        while(curr != next) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return  prev;
    }
}
