package com.practice.programming;

class Node {
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}

public class LinkListMiddleNode {
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


        System.out.println(getMidNodeData(node1));

    }

    private static int getMidNodeData(Node head) {
         Node slow, fast;
         slow = fast = head;
         while(fast != null && fast.next != null) {
             slow = slow.next;
             fast = fast.next.next;
             if (fast != null)
                 fast = fast.next;
         }
         if(fast == null)  // even length list
             return slow.data;
         if(fast.next == null) // odd length list
             return slow.data;
         return -1;

    }
}
