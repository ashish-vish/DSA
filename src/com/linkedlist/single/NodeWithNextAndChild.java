package com.linkedlist.single;

import java.util.ArrayList;

public class NodeWithNextAndChild {
    int data;
    NodeWithNextAndChild next;
    NodeWithNextAndChild child;

    NodeWithNextAndChild(int x) {
        data = x;
        next = null;
        child = null;
    }

    public static void printChildOfNodeWithNextAndChild(NodeWithNextAndChild head) {
        NodeWithNextAndChild temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.child;
        }
    }

    static void printOriginalLinkedList(NodeWithNextAndChild head, int depth) {
        while (head != null) {
            System.out.print(head.data);

            // If child exists, recursively
            // print it with indentation
            if (head.child != null) {
                System.out.print(" -> ");
                printOriginalLinkedList(head.child, depth + 1);
            }

            // Add vertical bars
            // for each level in the grid
            if (head.next != null) {
                System.out.println();
                for (int i = 0; i < depth; ++i) {
                    System.out.print("| ");
                }
            }
            head = head.next;
        }
    }

    public static NodeWithNextAndChild convertArrListIntoLL(ArrayList<Integer> arr) {
        NodeWithNextAndChild dummyNode = new NodeWithNextAndChild(-1);
        NodeWithNextAndChild temp = dummyNode;

        // Iterate through the ArrayList and
        // create nodes with elements
        for (int i = 0; i < arr.size(); i++) {
            // Create a new node with the element
            temp.child = new NodeWithNextAndChild(arr.get(i));
            // Move the temporary pointer
            // to the newly created node
            temp = temp.child;
        }
        // Return the linked list starting
        // from the next of the dummy node
        return dummyNode.child;

    }

    public static NodeWithNextAndChild getALinkedListWithChildAndNExt() {

        NodeWithNextAndChild head = new NodeWithNextAndChild(5);
        head.child = new NodeWithNextAndChild(14);

        head.next = new NodeWithNextAndChild(10);
        head.next.child = new NodeWithNextAndChild(4);

        head.next.next = new NodeWithNextAndChild(12);
        head.next.next.child = new NodeWithNextAndChild(20);
        head.next.next.child.child = new NodeWithNextAndChild(13);

        head.next.next.next = new NodeWithNextAndChild(7);
        head.next.next.next.child = new NodeWithNextAndChild(17);

        return head;
    }

}
