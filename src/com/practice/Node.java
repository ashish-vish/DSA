package com.practice;

import java.util.ArrayList;

public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public static void printLL(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }

    public static Node convertArrayListToLinkedList(ArrayList<Integer> list){
        Node head = new Node(-1);
        Node temp = head;

        for(Integer i : list){
            Node newNode = new Node(i);
            temp.next = newNode;
            temp = temp.next;
        }

        return head.next;
    }
}
