package com.practice.programming;

public class MergeSortedList {
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

        Node node11 = new Node(2);
        Node node21 = new Node(4);
        Node node31 = new Node(7);
        Node node41 = new Node(8);
        Node node51 = new Node(10);
        Node node61 = new Node(13);

        //1-> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
        node11.next = node21;
        node21.next = node31;
        node31.next = node41;
        node41.next = node51;
        node51.next = node61;

//        ReverseLinkList.printList(node1);
//        ReverseLinkList.printList(node11);

        Node head = mergeSorted(node1, node11);
        ReverseLinkList.printList(head);
    }

    private static Node mergeSorted(Node head1, Node head2) {
        Node mergedHead = null, curr;

        curr = mergedHead;
        while(head1 != null && head2 != null) {
            if(head1.data < head2.data) {
                if(mergedHead == null) {
                    mergedHead = head1;
                    curr = mergedHead;
                }
                else{
                    curr.next = head1;
                    curr     = curr.next;
                }
                head1 = head1.next;
            }
            else {
                if(mergedHead == null) {
                    mergedHead = head2;
                    curr = mergedHead;
                }
                else {
                    curr.next = head2;
                    curr = curr.next;
                }
                head2 = head2.next;
            }
//            curr = curr.next;
//            ReverseLinkList.printList(mergedHead);
        }
        if(head1 != null)
            curr.next = head1;
        else
            curr.next = head2;
        return mergedHead;
    }
}
