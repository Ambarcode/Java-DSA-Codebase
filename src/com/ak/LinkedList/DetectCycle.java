package com.ak.LinkedList;

class DetectCycle<T> {
    public static void main(String[] args) {
        ListNode<Integer> node = new ListNode<>(1);
        ListNode<Integer> node1 = new ListNode<>(2);
        node.next = node1;
        ListNode<Integer> node3 = new ListNode<>(3);
        node1.next = node3;
        ListNode<Integer> node4 = new ListNode<>(4);
        node3.next = node4;
        ListNode<Integer> node5 = new ListNode<>(5);
        node4.next = node5;
        node5.next = node;

        DetectCycle<Integer> dt = new DetectCycle<>();
        System.out.println(dt.detectCycle(node));
    }

    // Using Floyd cycle detection technique
    public boolean detectCycle(ListNode<T> head) {
        ListNode<T> slow = head;
        ListNode<T> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
