package com.linkedlist.single;

import java.util.ArrayList;

public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public static int getLengthOfLinkedList(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node getALinkedList(){
        return convertArrLL(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    public static Node convertArrLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp=newNode;
        }
        return head;
    }

    public static Node convertArrListIntoLL(ArrayList<Integer> list) {
        Node head = new Node(list.get(0));
        Node temp = head;
        for (int i = 1; i < list.size(); i++) {
            Node newNode = new Node(list.get(i));
            temp.next = newNode;
            temp=newNode;
        }
        return head;
    }

    public static Node createCircularLinkedList(){
        Node head = new Node(11);
        Node second = new Node(22);
        Node third = new Node(33);
        Node fourth = new Node(44);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        fifth.next = third;
        return head;
    }

    public static void getYIntersectionLists(Node headA, Node headB) {
        headA.next = new Node(2);
        headA.next.next = new Node(3);
        headA.next.next.next = new Node(4);
        headA.next.next.next.next = new Node(5);
        headA.next.next.next.next.next = new Node(6);
        headA.next.next.next.next.next.next = new Node(7);
        headA.next.next.next.next.next.next.next = new Node(8);



        headB.next = headA.next.next.next.next.next;
    }
}
