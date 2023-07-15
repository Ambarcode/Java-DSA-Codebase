package com.ak.LinkedList;

public class RemoveDuplicatedFromSortedList {

    private static<T> ListNode<T> remove(ListNode<T> head){
        ListNode<T> nodeA=head;
        if (head==null|| head.next==null) return head;
        ListNode<T> nodeB=head.next;
        while (nodeB!=null) {
           if (nodeA.data==nodeB.data){
               nodeA.next=nodeB.next;
           }else nodeA=nodeA.next;

           nodeB=nodeB.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
