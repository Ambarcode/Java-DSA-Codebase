package com.ak.LinkedList;

public class RemoveDuplicatesFromSortedListii<T> {
    public ListNode<T> deleteDuplicates(ListNode<T> head) {
        //the approach is to used keep a pointer ahead where duplicacy starts and update the links

        if(head==null || head.next==null) return head;
        //to handle the first node we have to create a dummy node
        ListNode<T> dummy=new ListNode<T>();
        dummy.next=head;
        ListNode<T> ptr=dummy;
        while(ptr.next!=null && ptr.next.next!=null){
            if(ptr.next.data==ptr.next.next.data){
                T elem=ptr.next.data;
                while(ptr.next!=null && ptr.next.data==elem){
                    ptr.next=ptr.next.next;
                }
            }
            else{
                ptr=ptr.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
