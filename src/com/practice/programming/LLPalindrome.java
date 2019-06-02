package com.practice.programming;



public class LLPalindrome {
    public static void main(String[] args) {
       Node n1 = new Node(1);
       Node n2 = new Node(2);
       Node n3 = new Node(2);
       Node n4  = new Node(1);
       Node n5 = new Node(1);
       n1.next = n2;
       n2.next = n3;
       n3.next = n4;
//       n4.next = n5;

//       System.out.printf(checkPalindrome(n1).toString());

       System.out.printf(checkPalindromeV2(n1).toString());
    }


    private  static void printLL(Node head){
        while(head != null){
            System.out.printf(head.data+" ");
            head  = head.next;
        }
    }

    private  static Boolean checkPalindromeV2(Node head){
        Node slow, fast, mid, prev = null;
        slow = fast = head;

        //1->2->3
        //1->2->3->4
        //1 2 3 2 1
        //1 2 2 1
        while(fast!=null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast == null) { // even length
            mid = slow;
        }
        else { //odd length
            prev = slow;
            mid = slow.next;
        }
        prev.next = reverseLLV2(mid);
        mid = prev.next;
        if(mid == null)
            return false;
        while(mid != null && head.data == mid.data){
            System.out.printf(mid.data +" "+head.data);
            head = head.next;
            mid = mid.next;
        }
        if(mid == null)
            return true;
        return  false;
    }
   private static Boolean checkPalindrome(Node head) {
      // Reverse
      Node  h = reverseLL(head);
//      printLL(h);
//       System.out.println(head.data);
      while(head != null && head.data == h.data){
//          System.out.printf(head.data +" "+h.data);
        head = head.next;
        h = h.next;
      }

      if(head == null && h == null)
          return true;
      return false;
   }
    private static Node reverseLLV2(Node head) {
        Node curr, prev, nxt;
        curr = head;
        prev = null;
        while(curr != null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr =nxt;
        }
        return prev;
    }

   private static Node reverseLL(Node head) {
        Node ret = null;
       Node curr, prev, nxt;
       curr = head;
       prev = null;
       Node temp = null;
       while(curr != null){
          temp = new Node(curr.data);
          if(ret == null) ret = temp;

          nxt = curr.next;
          temp.next = prev;
//          curr.next = prev;
          prev = temp;
          curr =nxt;
       }
       return temp;
   }
}
