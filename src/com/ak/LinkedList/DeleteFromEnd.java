package com.ak.LinkedList;

class DeleteFromEnd<T> {

    public static void main(String[] args) {

        DeleteFromEnd<Integer> dl = new DeleteFromEnd<>();
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(2);
//        head.next.next = new ListNode<>(3);
//        head.next.next.next = new ListNode<>(4);
//        head.next.next.next.next = new ListNode<>(5);
//        head.next.next.next.next.next = new ListNode<>(6);
//        head.next.next.next.next.next.next = new ListNode<>(7);

        head = dl.deleteFromLast(head, 2);

        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println("NULL");
    }

    private ListNode<T> deleteFromLast(ListNode<T> head, int pos) {
        // We'll solve it using two pointer approach only
        ListNode<T> p = head;
        ListNode<T> q = head;
        if (head.next == null) {
            return null;
        }
        while (pos > 1) {
            p = p.next;
            pos--;
        }
        ListNode<T> prev = null;
        while (p != null && p.next != null) {
            prev = q;
            q = q.next;
            p = p.next;
        }

        if (prev == null) { //it means q is pointing to the first, and we just need to shift the head pointer
            head = q.next;
        } else {
            prev.next = q.next;
        }
        q.next = null;
        return head;
    }
}
