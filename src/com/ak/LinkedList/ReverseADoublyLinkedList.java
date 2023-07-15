//package com.ak.LinkedList;
//
//public class ReverseADoublyLinkedList<T> {
//    void reverse(Node head)
//    {
//        Node temp = null;
//        Node current = head;
//
//        /* swap next and prev for all nodes of
//         doubly linked list */
//        while (current != null) {
//            temp = current.prev;
//            current.prev = current.next;
//            current.next = temp;
//            current = current.prev;
//        }
//
//        /* Before changing head, check for the cases like
//         empty list and list with only one node */
//        if (temp != null) {
//            head = temp.prev;
//        }
//    }
//}
