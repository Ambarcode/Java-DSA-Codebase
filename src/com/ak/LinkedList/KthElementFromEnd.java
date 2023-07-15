package com.ak.LinkedList;

class KthElementFromEnd<T> {

    public static void main(String[] args) {
        KthElementFromEnd<Integer> obj = new KthElementFromEnd<>();
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(2);
//        head.next.next = new ListNode<>(3);
//        head.next.next.next = new ListNode<>(4);
//        head.next.next.next.next = new ListNode<>(5);
//        head.next.next.next.next.next = new ListNode<>(6);
//        head.next.next.next.next.next.next = new ListNode<>(7);

        ListNode<Integer> node = obj.findKthElem2(head, 2);
        if (node != null) System.out.println(node.data);
        else System.out.println("Null");
    }

    //we'll solve it using two approaches
    //Approach 1: count the no. of nodes , as kth element from the end is N-k+1 element from the starting
    // Time Complexity: O(2N)
    private ListNode<T> findKthElem(ListNode<T> head, int k) {
        //first count the no. of nodes
        int nodes = 0;
        ListNode<T> curr = head;
        while (curr != null) {
            curr = curr.next;
            nodes += 1;
        }
        int move = nodes - k + 1;
        curr = head;
        while (move > 1) {
            curr = curr.next;
            move--;
        }
        return curr;
    }

    //Approach 2: Now instead of traversing two times , we can solve the question in a single traversal , using two pointers
    //Also known as Runners-up approach
    private ListNode<T> findKthElem2(ListNode<T> head, int pos) {
        ListNode<T> p = head;
        ListNode<T> q = head;

        while (pos > 1) {
            p = p.next;
            pos--;
        }

        while (p != null && p.next != null) {
            q = q.next;
            p = p.next;
        }
        return q;
    }
}
