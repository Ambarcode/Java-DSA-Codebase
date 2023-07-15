package com.ak.LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class MergeKSortedList<T> {
//    You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
//    Merge all the linked-lists into one sorted linked-list and return it.

    //Approach 1: store the data of in a list , sort the data using Collections.sort , create a new linkedlist
    public static <T> ListNode<T> mergeKLists(ListNode<T>[] lists) {
        List<Integer> list = new ArrayList<>();
        for (ListNode<T> node : lists) {
            while (node != null) {
                list.add((Integer) node.data);
                node = node.next;
            }
        }
        if (list.size() == 0) {
            return null;
        }
        Collections.sort(list);

        ListNode<T> head = new ListNode(list.get(0));
        ListNode<T> temp = head;
        for (int i = 1; i < list.size(); i++) {
            temp.next = new ListNode(list.get(i));
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    //Approach-2 Using Min-Heap
    public static <T> ListNode<T> mergeKLists2(ListNode<T>[] lists) {
        if (lists.length == 0) return null;

        PriorityQueue<T> que = new PriorityQueue<>();
        for (ListNode<T> node : lists) {
            while (node != null) {
                que.add(node.data);
                node = node.next;
            }
        }

        //making a head pointer

        ListNode<T> head;
        if (!que.isEmpty()) {
            head = new ListNode<T>(que.poll());
        } else {
            return null;
        }

        ListNode<T> temp = head;
        while (!que.isEmpty()) {
            temp.next = new ListNode<T>(que.poll());
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
}
