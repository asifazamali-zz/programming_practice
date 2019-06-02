package com.practice.programming;

import java.util.Objects;

public class LLDelWithouHead {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node( 3);
        Node n4 = new Node(4);
        Node n5 = new Node( 5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;


        delNode(n5);
        printLL(n1);
    }

    private static void printLL(Node head) {
       while (Objects.nonNull(head)){
           System.out.printf(head.data + " ");
           head = head.next;
       }
    }

    private static void delNode(Node delNode) {
       Node next = delNode.next;
       delNode.data = next.data;
       delNode.next = next.next;
    }
}
