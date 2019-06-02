package com.practice.programming;

import java.util.Objects;


public class LLSort {
    public static void main(String[] args) {
        Node n1 = new Node(0);
        Node n2 = new Node(2);
        Node n3 = new Node(0);
        Node n4 = new Node(1);
        Node n5 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        sortLL(n1);
        printLL(n1);
    }

    private static void printLL(Node head) {
        while(head != null){
            System.out.printf(head.data + " ");
            head = head.next;
        }
    }

    private static void sortLL(Node head) {
        Node curr = head, next;
        int zero, ones, twos;
        zero = ones = twos = 0;
        while (curr != null) {
            next = curr.next;
            if (curr.data == 0)
                zero++;
            else if (curr.data == 1)
                ones++;
            else if (curr.data == 2)
                twos++;
            curr = next;
        }
        curr = head;
        while(zero >0){
            curr.data = 0;
            zero--;
            curr = curr.next;
        }
        while (ones > 0){
            curr.data = 1;
            ones--;
            curr = curr.next;
        }
        while (twos > 0){
            curr.data = 2;
            twos--;
            curr = curr.next;
        }
    }
}
