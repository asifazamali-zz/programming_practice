package com.practice.programming;

public class LoopDetection {
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

        System.out.println(checkLoop(node1));
    }

    private static boolean checkLoop(Node head) {
        Node slow, fast;
        slow = fast = head;
        while(fast != null && slow != fast) {
            slow = slow.next;
            fast = fast.next;
            if(fast != null)
                fast = fast.next;

        }

        if(fast != null)
            return true;
        return false;
    }
}
