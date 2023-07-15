package com.ak.LinkedList;

class Merge2SortedList<T> {
    //You are given the heads of two sorted linked lists list1 and list2
    //Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
    //Return the head of the merged linked list.
    public static <T> ListNode<T> mergeTwoLists(ListNode<T> list1, ListNode<T> list2) {
        ListNode<T> dummy = new ListNode<T>();
        ListNode<T> curr = dummy;

        while (list1 != null && list2 != null) {
            if ((Integer) list1.data <= (Integer) list2.data) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = list1 == null ? list2 : list1;
        return dummy.next;

    }
}
