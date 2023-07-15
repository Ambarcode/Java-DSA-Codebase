package com.ak.LinkedList;

public class SwapNodesInPair<T> {
    private static<T> ListNode<T> swapNodesInPair(ListNode<T> head){
        ListNode<T> temp=new ListNode<T>();
        if (head==null || head.next==null) return head;

        ListNode<T> p=temp;
        ListNode<T> q=temp.next;

        while (q!=null && q.next!=null){
            p.next=q.next;
            q.next=q.next.next;
            p.next.next=q;

            p=p.next;
            q=q.next;
        }
        return temp.next;
    }
}
