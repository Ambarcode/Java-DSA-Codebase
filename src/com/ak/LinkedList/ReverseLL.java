package com.ak.LinkedList;

class ReverseLL<T> {

    private static <T> ListNode<T> reverse(ListNode<T> root) {
        //Iterative Approach
        if (root == null || root.next == null) return null;
        ListNode<T> prev = null;
        ListNode<T> curr = root;
        ListNode<T> next = curr.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) next = next.next;
        }
        root = prev;
        return root;
    }

    //Now we look at the recursive approach
    private static <T> ListNode<T> reverse2(ListNode<T> head) {
        if (head == null || head.next == null) return head;

        ListNode<T> restHead = reverse(head.next);
        ListNode<T> resTail = head.next;
        resTail.next = head;
        head.next = null;
        return restHead;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        head.next.next.next.next = new ListNode<>(5);
        head.next.next.next.next.next = new ListNode<>(6);
        head.next.next.next.next.next.next = new ListNode<>(7);
        ListNode<Integer> node = reverse(head);
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println("NULL");
    }
}
