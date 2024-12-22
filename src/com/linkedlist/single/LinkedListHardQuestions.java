package com.linkedlist.single;

import java.util.ArrayList;
import java.util.Collections;

import static com.linkedlist.single.NodeWithNextAndChild.convertArrListIntoLL;
import static com.linkedlist.single.NodeWithNextAndChild.getALinkedListWithChildAndNExt;
import static com.linkedlist.single.NodeWithNextAndChild.printChildOfNodeWithNextAndChild;
import static com.linkedlist.single.NodeWithNextAndChild.printOriginalLinkedList;

public class LinkedListHardQuestions {

    public static NodeWithNextAndChild flattenLinkedList(NodeWithNextAndChild head) {
        if (head == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        NodeWithNextAndChild temp = head;
        while (temp != null) {
            NodeWithNextAndChild tempChild = temp;
            while (tempChild != null) {
                list.add(tempChild.data);
                tempChild = tempChild.child;
            }
            temp = temp.next;
        }
        Collections.sort(list);
        return convertArrListIntoLL(list);
    }
    public static void main(String[] args) {
        NodeWithNextAndChild head = getALinkedListWithChildAndNExt();
        printOriginalLinkedList(head,0);
        System.out.println();
        head = flattenLinkedList(head);
        printChildOfNodeWithNextAndChild(head);
    }
}
