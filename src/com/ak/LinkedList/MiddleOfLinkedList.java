package com.ak.LinkedList;

class MiddleOfLinkedList<T> {
    // We'll use the same approach above i.e. slow and fast pointer

    public static void main(String[] args) {
        // Example usage
        MiddleOfLinkedList<Integer> middleFinder = new MiddleOfLinkedList<>();

        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(2);
//        head.next.next = new ListNode<>(3);
//        head.next.next.next = new ListNode<>(4);
//        head.next.next.next.next = new ListNode<>(5);

        ListNode<Integer> middleNode = middleFinder.findMiddle(head);

        if (middleNode != null) {
            System.out.println("Middle node value: " + middleNode.data);
        } else {
            System.out.println("Empty list.");
        }
    }

    ListNode<T> findMiddle(ListNode<T> node) {
        if (node == null) {
            return null;
        }

        ListNode<T> fast = node;
        ListNode<T> slow = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow will point to mid when fast reaches null
        return slow;
    }
}
