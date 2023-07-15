package com.ak.LinkedList;

public class RotateList<T> {
    //Simple Approach , just count the length of list and subtract the number of rotation from it
    //move the pointer ahead by the resultant value and make it's next head and remove the linkage(remember to join the starting point also
    public ListNode<T> rotateRight(ListNode<T> head, int k) {
        if(k==0|| head==null || head.next==null) return head;

        int length=1;
        ListNode<T> last=head;
        while(last.next!=null){
            last=last.next;
            length++;
        }

        last.next=head;

        int noOfRotations=k%length;
        int skip=length-noOfRotations;
        ListNode<T> newLast=head;
        for(int i=0;i<skip-1;i++){
            newLast=newLast.next;
        }

        head=newLast.next;
        newLast.next=null;

        return head;
    }
}
