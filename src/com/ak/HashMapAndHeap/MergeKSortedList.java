package com.ak.HashMapAndHeap;



import java.util.PriorityQueue;

public class MergeKSortedList {
   //we'll store all the nodes value in the priority queue than create a new list
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
   private static class ListNode<T> {
       ListNode<T> next;
       T data;

       public ListNode(T data){
           this.data=data;
           this.next=null;
       }
   }
}
