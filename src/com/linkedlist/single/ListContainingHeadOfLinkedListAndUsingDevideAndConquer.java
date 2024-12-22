package com.linkedlist.single;

import java.util.ArrayList;
import java.util.Arrays;

import static com.linkedlist.single.Node.convertArrListIntoLL;
import static com.linkedlist.single.Node.printLL;

public class ListContainingHeadOfLinkedListAndUsingDevideAndConquer {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 5, 9, 10, 15, 16));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2, 3, 6, 9, 10));
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(5, 7, 18, 21, 25, 50));
        ArrayList<Integer> list4 = new ArrayList<>(Arrays.asList(23, 16, 30, 33, 32, 25));
        ArrayList<Integer> list5 = new ArrayList<>(Arrays.asList(1, 5, 8, 19, 20, 27));

        Node head1 = convertArrListIntoLL(list1);
        Node head2 = convertArrListIntoLL(list2);
        Node head3 = convertArrListIntoLL(list3);
        Node head4 = convertArrListIntoLL(list4);
        Node head5 = convertArrListIntoLL(list5);

        ArrayList<Node> nodeArrayList = new ArrayList<>();
        nodeArrayList.add(head1);
        nodeArrayList.add(head2);
        nodeArrayList.add(head3);
        nodeArrayList.add(head4);
        nodeArrayList.add(head5);

        Node result = mergeKLists(nodeArrayList);
        printLL(result);
    }

    private static Node mergeKLists(ArrayList<Node> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        return mergeLists(lists, 0, lists.size() - 1);
    }

    private static Node mergeLists(ArrayList<Node> lists, int left, int right) {
        if (left == right) {
            return lists.get(left);
        }
        int mid = (left + right) / 2;
        Node l1 = mergeLists(lists, left, mid);
        Node l2 = mergeLists(lists, mid + 1, right);
        return mergeTwoSortedLinkedLists(l1, l2);
    }

    private static Node mergeTwoSortedLinkedLists(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node current = dummy;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }
        if (head1 != null) {
            current.next = head1;
        } else {
            current.next = head2;
        }
        return dummy.next;
    }
}

