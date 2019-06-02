package com.practice.programming;

public class LLStack {
    private Node head;
    public LLStack(){
        head = null;
    }
    public void push(int data){
        Node temp = new Node(data);
        if(head == null)
            head = temp;
        else{
            temp.next = head;
            head = temp;
        }
    }

    public int pop(){
        int data;
       if(head == null){
           System.out.println("empty");
           return  -1;
       }
       data = head.data;
       head = head.next;
       return data;
    }

    public static void main(String[] args) {
        LLStack llStack = new LLStack();
        llStack.push(3);
        llStack.push(4);
        llStack.push(5);
        llStack.push(6);

        System.out.printf(llStack.pop() + " "+ llStack.pop() + " "+ llStack.pop() + " "+llStack.pop());
    }
}
