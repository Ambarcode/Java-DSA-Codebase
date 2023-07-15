package com.ak.LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node
{
    int data;
    Node next;
    Node bottom;

    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}
public class FlatteningLL
{
    Node flatten(Node root)
    {
        //if(root==null || root.next==null || root.bottom==null) return root;

        List<Integer> list=new ArrayList<>();
        Node curr=root;
        while(curr!=null){
            Node newCurr=curr;
            while(newCurr!=null){
                list.add(newCurr.data);
                newCurr=newCurr.bottom;
            }
            curr=curr.next;
        }

        //now we'll sort our list
        Collections.sort(list);

        if(list.size()==0) return null;
        Node head=new Node(list.get(0));

        Node curr1=head;
        for(int i=1;i<list.size();i++){
            curr1.bottom=new Node(list.get(i));
            curr1=curr1.bottom;
        }

        curr1.bottom=null;
        return head;

    }
}
