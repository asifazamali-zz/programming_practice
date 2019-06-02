package com.practice.programming;

public class ReverseKNodes {
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

        int k = 6;

        Node head = reverseKNodes(node1, k);
        ReverseLinkList.printList(head);
    }

    private static Node reverseKNodes(Node head, int k) {
        if(head == null) return null;
        int temp = k;
        Node curr = head, last = head, nxt;
        while(--temp > 0 && last != null) {
            last = last.next;
        }
        if(last == null) return reverse(head, null);
        nxt = last.next;
        ReverseLinkList.printList(head);

        head = reverse(head, nxt);
        ReverseLinkList.printList(head);
        curr.next = reverseKNodes(nxt, k);
        return  head;
    }

    private static Node reverse(Node head, Node next) {
        Node prev , curr, nxt;
        prev = null;
        curr = head;
        while(curr != next) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
}
