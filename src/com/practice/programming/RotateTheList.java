package com.practice.programming;


public class RotateTheList {
    public static void main(String[] args) {
        Node node1 = new Node(3);
        Node node2 = new Node(5);
        Node node3 = new Node(6);
        Node node4 = new Node(7);
        Node node5 = new Node(8);
        // 3 -> 5 -> 6 -> 7 -> 8
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        int k = 6;
//        Node head = rotateClockwise(node1, k);
        ReverseLinkList.printList(node1);
        Node head1 = rotateAntiClockwise(node1, k);
//        ReverseLinkList.printList(head);
        ReverseLinkList.printList(head1);
    }

    private static Node rotateAntiClockwise(Node head, int k ) {
        Node curr, nxt, last;
        curr = head;

        while(curr != null && --k > 0) {
           curr = curr.next;
        }


        if(curr == null || curr.next == null)
            return head;
        nxt = curr.next;
        last = nxt;
        while(last.next != null) {
            last = last.next;
        }
        last.next = head;
        curr.next = null;
        head = nxt;
        return head;
    }

    private static Node rotateClockwise(Node head, int k) {
        Node slow, fast, nxt;
        if(head == null) return null;
        slow = fast = head;
        while(k-- > 0 && fast!= null) {
            fast = fast.next;
        }
        if(fast == null) { // k == length
            return head;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        nxt = slow.next;
        fast.next = head;
        slow.next = null;
        head = nxt;
        return head;

    }
}
