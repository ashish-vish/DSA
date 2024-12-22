package com.linkedlist.doubleLinkedList;

import java.util.ArrayList;

import static com.linkedlist.doubleLinkedList.Node.convertArr2DLL;
import static com.linkedlist.doubleLinkedList.Node.printDLL;

public class Main {

    private static Node insertAtEnd(int k, Node head) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(k);
        temp.next = newNode;
        newNode.back = temp;
        return head;
    }

    public static Node deleteAllOccurencesOfKey(Node head, int k) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == k) {
                if (temp == head) {
                    head = head.next;
                }
                Node prev = temp.back;
                Node next = temp.next;

                if (next != null)
                    next.back = prev;
                if (prev != null)
                    prev.next = next;
                temp = next;
            } else
                temp = temp.next;
        }
        return head;
    }

    public static Node getLastNode(Node head) {
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        return temp;
    }

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Node first = head;
        Node last = getLastNode(head);

        while (first.data < last.data) {
            if (first.data + last.data == target) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(first.data);
                list.add(last.data);
                res.add(list);
                first = first.next;
                last = last.back;
            } else if (first.data + last.data > target) {
                last = last.back;
            } else
                first = first.next;
        }
        return res;
    }

    public static Node removeDuplicates(Node head) {
        Node temp = head;
        while (temp != null && temp.next != null) {
            Node nextNode = temp.next;
            while (nextNode != null && nextNode.data == temp.data) {
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            if(nextNode != null)
                nextNode.back = temp;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
//        Node head = Node.convertArr2DLL(new int[] { 1, 2, 3,4});
//        int k = 6;
//        Node.printDLL(head);
//        head = insertAtEnd(k,head);
//        Node.printDLL(head);
//        Node deleteOccurencesOfKey = convertArr2DLL(new int[]{3,3,1,3,3});
//        printDLL(deleteOccurencesOfKey);
//        deleteOccurencesOfKey = deleteAllOccurencesOfKey(deleteOccurencesOfKey, 3);
//        printDLL(deleteOccurencesOfKey);
//        Node lastNode = getLastNode(convertArr2DLL(new int[]{1}));
//        System.out.println(lastNode.data);

//        ArrayList<ArrayList<Integer>> pairsWithGivenSum = findPairsWithGivenSum(6, convertArr2DLL(new int[]{0,1, 2,3, 4,5,6}));
//        System.out.println(pairsWithGivenSum);

        Node removeDuplicate = convertArr2DLL(new int[]{0,1,1,1});
        printDLL(removeDuplicates(removeDuplicate));
    }
}
