package com.linkedlist.single;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import static com.linkedlist.single.NodeWithComprable.convertArrListIntoLL;
import static com.linkedlist.single.NodeWithComprable.printLL;


/**
 * An ArrayList containing head linkedList, all the LinkedList are sorted.
 * Return a Sorted LinkedList containing all the linkedLists
 */
public class ListContainingHeadOfLinkedListUsingHeap {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 5, 9, 10, 15,16));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2,3,6,9,10));
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(5,7,18,21,25,50));
        ArrayList<Integer> list4 = new ArrayList<>(Arrays.asList(23,16,30,33,32,25));
        ArrayList<Integer> list5 = new ArrayList<>(Arrays.asList(1,5,8,19,20,27));

        NodeWithComprable head1 = convertArrListIntoLL(list1);
        NodeWithComprable head2 = convertArrListIntoLL(list2);
        NodeWithComprable head3 = convertArrListIntoLL(list3);
        NodeWithComprable head4 = convertArrListIntoLL(list4);
        NodeWithComprable head5 = convertArrListIntoLL(list5);

        ArrayList<NodeWithComprable> nodeArrayList = new ArrayList<>();
        nodeArrayList.add(head1);
        nodeArrayList.add(head2);
        nodeArrayList.add(head3);
        nodeArrayList.add(head4);
        nodeArrayList.add(head5);

        NodeWithComprable result = getSortedListOfAllLists(nodeArrayList);
        printLL(result);
    }

    private static NodeWithComprable getSortedListOfAllLists(ArrayList<NodeWithComprable> nodeArrayList) {

        PriorityQueue<NodeWithComprable> pq= new PriorityQueue<>();
        pq.addAll(nodeArrayList);
        NodeWithComprable result = new NodeWithComprable(-1);
        NodeWithComprable resultTemp = result;

        while (!pq.isEmpty()){
            NodeWithComprable newNode = pq.poll();
            resultTemp.next = new NodeWithComprable(newNode.data);
            resultTemp = resultTemp.next;
            if (newNode.next != null)
                pq.add(newNode.next);
        }
        return result.next;
    }

}
