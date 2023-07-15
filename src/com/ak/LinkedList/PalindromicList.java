package com.ak.LinkedList;

import java.util.Stack;

public class PalindromicList {
    //Approach1: Put all the elements on to the stack, then traverse through the list and  compare it with stack.pop

    private static <T> boolean isPalindrome(ListNode<T> head){
        Stack<T> data=new Stack<>();
        ListNode<T> curr=head;
        while (curr!=null){
            data.push(curr.data);
            curr=curr.next;
        }

        //Traverse through the list and check
        curr=head;
        while (curr!=null){
            T elem=data.pop();
            if (elem!=curr.data) return false;
            curr=curr.next;
        }
        return true;
    }

    //Approach-2(Efficient Approach) Without using Stack data structure
    //we'll reverse the list from between and compare it from starting until mid
    private static<T> boolean reverse2(ListNode<T> head){
        if (head==null || head.next==null) return true;
        ListNode<T> curr=head;
        //finding the mid of the linkedlist
        ListNode<T> mid=findMid(curr);
        //reverse after mid
        ListNode<T> curr2= reverse(mid.next);
        while (curr2!=null && curr!=null){
            if(curr.next!=curr2.next){
                return false;
            }
            curr=curr.next;
            curr2=curr2.next;
        }
        return true;
    }

    private static<T> ListNode<T> findMid(ListNode<T> node){
        ListNode<T> fast=node;
        ListNode<T> slow=node;

        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    private static<T> ListNode<T> reverse(ListNode<T> root){
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
}
