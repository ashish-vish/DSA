package com.linkedlist.doubleLinkedList;

public class Node {
    int data;
    Node next;
    Node back;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }

    public Node (int data, Node next, Node back) {
        this.data = data;
        this.next = next;
        this.back = back;
    }

    public static void printDLL(Node head) {
        if (head == null) {
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static Node convertArr2DLL(int[] arr){
        Node head = new Node(arr[0]);
        Node tail = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            temp.back = tail;
            tail.next = temp;
            tail = temp;
        }
        return head;
    }
}
