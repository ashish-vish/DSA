package com.stack;

public class Stack {
    Node head = new Node(-1);

    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void peek() {
        if (head.data == -1) {
            System.out.println("stack is empty");
            return;
        }
        System.out.println(head.data);
    }

    public void pop() {
        if (head.data == -1){
            System.out.println("stack is empty");
            return;
        }
        System.out.println(head.data);
        if (head.next!=null)
            head=head.next;
    }
}
