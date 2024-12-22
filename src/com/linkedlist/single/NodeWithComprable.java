package com.linkedlist.single;

import java.util.ArrayList;

public class NodeWithComprable implements Comparable<NodeWithComprable> {
    int data;
    NodeWithComprable next;

    public NodeWithComprable(int data) {
        this.data = data;
        this.next = null;
    }

    public NodeWithComprable(int data, NodeWithComprable next) {
        this.data = data;
        this.next = next;
    }

    public static int getLengthOfLinkedList(NodeWithComprable head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static void printLL(NodeWithComprable head) {
        NodeWithComprable temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static NodeWithComprable getALinkedList(){
        return convertArrLL(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    public static NodeWithComprable convertArrLL(int[] arr) {
        NodeWithComprable head = new NodeWithComprable(arr[0]);
        NodeWithComprable temp = head;
        for (int i = 1; i < arr.length; i++) {
            NodeWithComprable newNode = new NodeWithComprable(arr[i]);
            temp.next = newNode;
            temp=newNode;
        }
        return head;
    }

    public static NodeWithComprable convertArrListIntoLL(ArrayList<Integer> list) {
        NodeWithComprable head = new NodeWithComprable(list.get(0));
        NodeWithComprable temp = head;
        for (int i = 1; i < list.size(); i++) {
            NodeWithComprable newNode = new NodeWithComprable(list.get(i));
            temp.next = newNode;
            temp=newNode;
        }
        return head;
    }

    public static NodeWithComprable createCircularLinkedList(){
        NodeWithComprable head = new NodeWithComprable(11);
        NodeWithComprable second = new NodeWithComprable(22);
        NodeWithComprable third = new NodeWithComprable(33);
        NodeWithComprable fourth = new NodeWithComprable(44);
        NodeWithComprable fifth = new NodeWithComprable(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        fifth.next = third;
        return head;
    }

    public static void getYIntersectionLists(NodeWithComprable headA, NodeWithComprable headB) {
        headA.next = new NodeWithComprable(2);
        headA.next.next = new NodeWithComprable(3);
        headA.next.next.next = new NodeWithComprable(4);
        headA.next.next.next.next = new NodeWithComprable(5);
        headA.next.next.next.next.next = new NodeWithComprable(6);
        headA.next.next.next.next.next.next = new NodeWithComprable(7);
        headA.next.next.next.next.next.next.next = new NodeWithComprable(8);



        headB.next = headA.next.next.next.next.next;
    }

    @Override
    public int compareTo(NodeWithComprable node) {
        return Integer.compare(this.data,node.data);
    }
}
