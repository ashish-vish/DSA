package com.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 5, 9, 10, 15,16));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2,3));

        Node head1 = Node.convertArrayListToLinkedList(list1);
        Node head2 = Node.convertArrayListToLinkedList(list2);

        Node result = mergeTwoSortedLinkedList(head1,head2);
        Node.printLL(result);
    }

    private static Node mergeTwoSortedLinkedList(Node head1, Node head2) {
        Node result = new Node(-1);
        Node resultTemp = result;

        while (head1 != null && head2 != null){
            if (head1.data > head2.data){
                resultTemp.next = new Node(head2.data);
                head2=head2.next;
            } else{
                resultTemp.next = new Node(head1.data);
                head1=head1.next;
            }
            resultTemp = resultTemp.next;
        }
        while (head1 != null){
            resultTemp.next = new Node(head1.data);
            resultTemp = resultTemp.next;
            head1=head1.next;
        }
        while (head2 != null){
            resultTemp.next = new Node(head2.data);
            resultTemp = resultTemp.next;
            head2=head2.next;
        }
        return result.next;
    }
}
