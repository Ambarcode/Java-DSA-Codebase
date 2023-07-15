package com.ak.LinkedList;

import java.util.HashSet;

class InterSectionLL<T> {

    //Given two LL , we have to find their intersection point i.e. where they met
    //Approach 1: Counting length of both the linkedlist , calculate the difference , move the head pointer difference times
    private static <T> ListNode<T> findInterSection(ListNode<T> head1, ListNode<T> head2) {

        int lengthA = length(head1);
        int lengthB = length(head2);
        int diff = Math.abs(lengthA - lengthB);
        if (lengthA > lengthB) {
            while (diff != 0) {
                head1 = head1.next;
                diff--;
            }
        } else {
            while (diff > 0) {
                head2 = head2.next;
                diff--;
            }
        }
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                // Step 5: Found the intersection point
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        // No intersection found
        return null;
    }

    //Approach-2
    //Now we'll see another approach we don't have to find the length of both the list
    //We'll solve this by runner approach , i.e. with the help of two pointer
    private static <T> ListNode<T> findInterSection2(ListNode<T> headA, ListNode<T> headB) {
        //In this approach we'll maintain two pointer each time a pointer reaches null , I'll again start it from head
        ListNode<T> ptrA = headA;
        ListNode<T> ptrB = headB;

        while (ptrA != ptrB) {
            ptrA = (ptrA == null) ? headB : ptrA.next;
            ptrB = (ptrB == null) ? headA : ptrB.next;
        }
        return ptrA;
    }

    //Approach 3:- Using Hashset
    private static <T> ListNode<T> findInterSection3(ListNode<T> headA, ListNode<T> headB) {
        //First we'll store create a set of ListNode
        HashSet<ListNode<T>> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    private static <T> int length(ListNode<T> head) {
        int count = 0;
        ListNode<T> curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }


    public static void main(String[] args) {
        // Create the linked lists
        ListNode<Integer> headA = new ListNode<>(4);
        ListNode<Integer> node1 = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(8);
        ListNode<Integer> node3 = new ListNode<>(4);
        ListNode<Integer> node4 = new ListNode<>(5);
        headA.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode<Integer> headB = new ListNode<>(5);
        ListNode<Integer> node5 = new ListNode<>(6);
        node5.next = node2; // Common intersection node
        headB.next = node5;

        // Find intersection point
        //ListNode<Integer> intersectionNode = findInterSection(headA, headB);
        ListNode<Integer> intersectionNode2 = findInterSection3(headA, headB);

        // Print the intersection point (value)
        if (intersectionNode2 != null) {
            System.out.println("Intersection Point: " + intersectionNode2.data);
        } else {
            System.out.println("No Intersection Point Found");
        }
    }
}
