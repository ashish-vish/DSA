package com.linkedlist.single;

import java.util.ArrayList;
import java.util.Arrays;

import static com.linkedlist.single.Node.convertArrListIntoLL;
import static com.linkedlist.single.Node.printLL;

/**
 * An ArrayList containing head linkedList, all the LinkedList are sorted.
 * Return a Sorted LinkedList containing all the linkedLists
 */
public class ListContainingHeadOfLinkedList {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 5, 9, 10, 15,16));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2,3,6,9,10));
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(5,7,18,21,25,50));
        ArrayList<Integer> list4 = new ArrayList<>(Arrays.asList(23,16,30,33,32,25));
        ArrayList<Integer> list5 = new ArrayList<>(Arrays.asList(1,5,8,19,20,27));

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

        Node result = getSortedListOfAllLists(nodeArrayList);
        printLL(result);
    }

    private static Node getSortedListOfAllLists(ArrayList<Node> nodeArrayList) {
        Node tempList = new Node(-1);
        if (nodeArrayList.isEmpty())
            return null;
        tempList = mergeTwoSortedLinkedList(tempList.next,nodeArrayList.get(0));
        for (int i=1;i<nodeArrayList.size();i++){
            tempList = mergeTwoSortedLinkedList(tempList,nodeArrayList.get(i));
        }
        return tempList;
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
