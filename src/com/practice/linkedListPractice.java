package com.practice;

import java.util.ArrayList;
import java.util.Arrays;

import static com.practice.Node.convertArrayListToLinkedList;
import static com.practice.Node.printLL;

public class linkedListPractice {

    static Node middleOfLinkedList(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        Node head = convertArrayListToLinkedList(list);
        printLL(head);
        System.out.println();
        int data = middleOfLinkedList(head).data;
        System.out.println(data);
    }
}
