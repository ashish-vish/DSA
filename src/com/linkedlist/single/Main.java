package com.linkedlist.single;

import java.util.HashMap;
import java.util.Map;

import static com.linkedlist.single.Node.convertArrLL;
import static com.linkedlist.single.Node.createCircularLinkedList;
import static com.linkedlist.single.Node.getALinkedList;
import static com.linkedlist.single.Node.getLengthOfLinkedList;
import static com.linkedlist.single.Node.getYIntersectionLists;
import static com.linkedlist.single.Node.printLL;

public class Main {

    public static Node insertHead(int val, Node head) {
        Node newNode = new Node(val, head);
        return newNode;
    }

    public static Node insertDataBeforeHead(int val, Node head) {
        if (head == null) {
            head = new Node(val);
            return head;
        }
        return insertHead(val, head);
    }

    public static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static Node middleNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node fastNode = head;
        Node slowNode = head;

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

    public static Node reverseLinkedList(Node head) {
        Node current = head;
        Node prev = null;

        while (current != null) {
            Node front = current.next;
            current.next = prev;
            prev = current;
            current = front;
        }
        return prev;
    }

    public static boolean detectLoop(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static Node getStartingNodeOfLoop(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static int getLengthOfLoop(Node head) {
        Node fast = head;
        Node slow = head;
        int length = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return getLengthOfLoop(slow, fast.next);
            }
        }
        return 0;
    }

    public static int getLengthOfLoop(Node slow, Node fast) {
        int length = 1;
        while (slow != fast) {
            length++;
            fast = fast.next;
        }
        return length;
    }

    public static boolean checkPallindrome(Node head) {
        Node middle = middleNode(head);
        Node first = head;
        Node second = reverseLinkedList(middle);
        printLL(first);
        printLL(second);
        while (first != null && second != null) {
            if (first.data != second.data) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }

    public static Node segregateEvenAndOddNodes(Node head) {
        Node current = head;
        Node evenList = null;
        Node evenLastNode = null;
        Node oddList = null;
        Node oddLastNode = null;

        while (current != null) {
            Node newNode = new Node(current.data);
            if (current.data % 2 == 0) {
                if (evenList == null) {
                    evenList = newNode;
                    evenLastNode = evenList;
                }
                evenLastNode.next = newNode;
                evenLastNode = newNode;
            } else {
                if (oddList == null) {
                    oddList = newNode;
                    oddLastNode = oddList;
                }
                oddLastNode.next = newNode;
                oddLastNode = newNode;
            }
            current = current.next;
        }
        printLL(evenList);
        printLL(oddList);
        evenLastNode.next = oddList;
        return evenList;
    }

    public static Node deleteNthNodeFromEnd(Node head, int n) {
        Node fast = head;
        Node slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null)
            return head;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static Node deleteMiddleNode(Node head) {

        if (head == null || head.next == null) {
            return null;
        }

        Node fast = head.next.next;
        Node slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static Node getYIntersectionNode(Node headA, Node headB) {
        // TODO: USE HASHSET NOT HASHMAP HERE
        Map<Node, Integer> map = new HashMap<>();
        while (headA != null) {
            map.put(headA, 0);
            headA = headA.next;
        }
        while (headB != null) {
            if (map.containsKey(headB))
                return headB;
            headB=headB.next;
        }
        return null;
    }

    public static Node getYIntersectionNodeByUsingDifferenceOfLength(Node headA, Node headB) {
        int lengthA = getLengthOfLinkedList(headA);
        int lengthB = getLengthOfLinkedList(headB);
        int difference = lengthB - lengthA;
        if (difference > 0) {
            while (difference-- !=0)
                headB = headB.next;
        }else {
            while (difference++ !=0)
                headA = headA.next;
        }
        while (headA != null){
            if (headB == headA)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public static Node getYIntersectionNodeByUsingDummyNodesToTraverseEqualNodes(Node headA, Node headB) {

        Node d1 = headA;
        Node d2 = headB;

        while (d1 != d2) {
            d1 = d1 == null ? headB : d1.next;
            d2 = d2 == null ? headA : d2.next;
        }
        return d1;
    }

    public static Node mergeTwoSortedLists(Node head1, Node head2) {
        Node dummyHead = new Node(-1);
        Node temp = dummyHead;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.next = head1;
                head1 = head1.next;
            }else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if (head1 != null)
            temp.next = head1;
        else
            temp.next = head2;
        return dummyHead.next;
    }

    public static Node findMiddleForMergeSort(Node head) {

        if(head == null || head.next == null)
            return head;

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node sortLL(Node head) {
        if (head == null || head.next == null)
            return head;

        Node middle = findMiddleForMergeSort(head);

        Node right = middle.next;
        middle.next = null;
        Node left = head;

        left = sortLL(left);
        right = sortLL(right);

        return mergeTwoSortedLists(left, right);
    }

    public static Node sortLinkedListOf012(Node head) {
        if (head == null )
            return head;
        Node zero = new Node(-1);
        Node one = new Node(-1);
        Node two = new Node(-1);
        Node temp =  head;
        Node zeroTemp = zero;
        Node oneTemp = one;
        Node twoTemp = two;

        while (temp != null) {
            Node newNode = new Node(temp.data);
            if(temp.data == 0){
                zeroTemp.next = newNode;
                zeroTemp = zeroTemp.next;
            }
            else if (temp.data == 1){
                oneTemp.next = newNode;
                oneTemp = oneTemp.next;
            }
            else {
                twoTemp.next = newNode;
                twoTemp = twoTemp.next;
            }
            temp = temp.next;
        }
        zeroTemp.next = one.next != null ? one.next : two.next;
        oneTemp.next = two.next;
        return zero.next;
    }


    public static void main(String[] args) {
        int val = 100;
//        Node head = getALinkedList();
//        printLL(head);
//        head = insertDataBeforeHead(val, head);
//        printLL(head);
//        head = deleteTail(head);
//        printLL(head);
//        printLL(convertArrLL(new int[]{1,2,3}));
//        System.out.println(middleNode(convertArrLL(new int[]{1, 2, 3, 4, 5})).data);
//        System.out.println(detectLoop(createCircularLinkedList()));
//        System.out.println(detectLoop(convertArrLL(new int[]{1, 2, 3, 4, 5})));
//        System.out.println(getStartingNodeOfLoop(createCircularLinkedList()).data);
//        Node head = convertArrLL(new int[]{1, 2, 3, 4, 5});
//        printLL(head);
//        head = reverseLinkedList(head);
//        printLL(head);
//        Node circularLinkedList = createCircularLinkedList();
//        System.out.println(getStartingNodeOfLoop(circularLinkedList).data);
//        System.out.println(getLengthOfLoop(circularLinkedList));
//        Node head = convertArrLL(new int[]{1,2,1,3,3,1,2,1});
//        System.out.println(checkPallindrome(head));
//        Node segregateList = convertArrLL(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
//        printLL(segregateEvenAndOddNodes(segregateList));
//        printLL(deleteNthNodeFromEnd(segregateList,3));de
//        Node head = getALinkedList();
//        printLL(head);
//        head = deleteMiddleNode(head);
//        printLL(head);
//        head = deleteMiddleNode(head);
//        printLL(head);
//        Node headA = new Node(1);
//        Node headB = new Node(1);
//        getYIntersectionLists(headA, headB);
//        printLL(headA);
//        printLL(headB);
//        System.out.println(getYIntersectionNode(headA, headB).data);
//        System.out.println(getYIntersectionNodeByUsingDifferenceOfLength(headA, headB).data);
//        System.out.println(getYIntersectionNodeByUsingDummyNodesToTraverseEqualNodes(headA, headB).data);

//        Node mergerSortLL = convertArrLL(new int[]{4, 2, 4, 5, 2, 1, 8, 44, 1,1});
//        mergerSortLL=sortLL(mergerSortLL);
//        printLL(mergerSortLL);

        Node sortLLOf012 = convertArrLL(new int[]{2,2,2,2,2,1,1,1,1,0,0,1,2});
        sortLLOf012=sortLinkedListOf012(sortLLOf012);
        printLL(sortLLOf012);

    }


}
