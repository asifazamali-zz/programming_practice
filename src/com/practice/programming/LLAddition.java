package com.practice.programming;

public class LLAddition {
    public static void main(String[] args) {
        Node  node1 = new Node(1);
        Node  node2 = new Node(2);
        Node  node3 = new Node(3);
        Node  node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node  node5 = new Node(5);
        Node  node6 = new Node(6);
        Node  node7 = new Node(7);

        node5.next = node6;
        node6.next = node7;
        // 1 -> 2 -> 3 -> 4
        // 5 -> 6 -> 7

        Node revList1 = reverseList(node1);
        // 4 -> 3 -> 2 -> 1
        // 7 -> 6 -> 5
        Node revList2 = reverseList(node5);

        Node head = addList(revList2, revList1);
        ReverseLinkList.printList(head);

    }

    private static Node addList(Node revList1, Node revList2) {
        int carry = 0;
        Node head = revList1, prev = null;
        if(revList1 == null) return revList2;
        if(revList2 == null) return  revList1;
        while(revList1 != null && revList2 != null) {
            int summ = (revList1.data + revList2.data + carry);
            carry =  summ / 10;
            revList1.data = summ % 10;
            prev = revList1;
            revList1 = revList1.next;
            revList2 = revList2.next;
        }
        if(revList1 == null) {
            prev.next = revList2;
            while(revList2 != null){
                int summ = (revList2.data + carry);
                carry =  summ/ 10;
                revList2.data  = summ % 10;
                revList2 = revList2.next;
            }
        }
        else if(revList2 == null) {
            while(revList1 != null) {
                int summ = (revList1.data + carry);
                carry = summ / 10;
                revList1.data = summ  % 10;
                revList1 = revList1.next;
            }
        }
        return  head;
    }

    private static Node reverseList(Node head) {
       Node curr, prev, nxt;
       curr = head;
       prev = null;
       while(curr != null) {
           nxt = curr.next;
           curr.next = prev;
           prev = curr;
           curr = nxt;
       }
       return  prev;
    }
}
