package com.ak.LinkedList;


import com.ak.Arrays.ArrayQuestion.TwoDimensionalArray.CheckForDuplicateInRowAndCol;

import java.util.*;

class ListNode<T> {
    T data;
    ListNode<T> next;

    public ListNode(){
        this.data=null;

    }

    public ListNode(T data) {
        this.data = data;
        this.next = null;
    }
}

class ListNodeOperations<T> {

    ListNode<T> head;
    ListNode<T> tail;
    int size;

    public ListNodeOperations() {
        head = null;
        tail = null;
        this.size = 0;
    }

    void addFirst(T data) {
        ListNode<T> curr = new ListNode<>(data);
        curr.next = head;
        head = curr;
        //if it is the first node
        if (tail == null) tail = head;
        size += 1;
    }

    void addLast(T data) {
        ListNode<T> curr = new ListNode<>(data);
        //if it is the first node
        if (head == null) addFirst(data);
        else {
            tail.next = curr;
            tail = curr;
        }
        size += 1;
    }

    void addAtPos(T data, int indx) throws Exception {
        //remember positioning start from 0
        if (indx > size) throw new Exception("Invalid Position");
        if (indx == 0) addFirst(data);
        if (indx == size) addLast(data);
        ListNode<T> node = new ListNode<>(data);
        ListNode<T> prev = head;
        while (indx > 1) {
            prev = prev.next;
            indx--;
        }
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public void addAtLastRecursive(T data) {
        head = addRecursiveHelper(head, data);
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    private ListNode<T> addRecursiveHelper(ListNode<T> current, T data) {
        if (current == null) {
            return new ListNode<>(data);
        }

        current.next = addRecursiveHelper(current.next, data);
        return current;
    }

    // Other methods and implementation details...


    T delFirst() {
        if (head == null) return null;
        T value = head.data;
        head = head.next;
        //if after deleting ,  linkedlist become empty
        if (head == null) tail = null;
        size--;
        return value;

    }

    T deleteLast() {
        if (size <= 1) delFirst();
        ListNode<T> temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        T val = temp.next.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    T deletAtPos(int index) throws Exception {
        if (index == 1) delFirst();
        if (index == size - 1) deleteLast();
        if (index > size) throw new Exception("Not a valid index");
        ListNode<T> prev = head;
        while (index > 1) {
            prev = prev.next;
            index--;
        }

        ListNode<T> curr = prev.next;
        prev.next = curr.next;
        curr.next = null;
        size--;
        return curr.data;

    }

    void print() {
        ListNode<T> curr = head;
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    ListNode<T> find(T val) {
        ListNode<T> temp = head;
        while (temp != null) {
            if (temp.data == val) return temp;
            temp = temp.next;
        }
        return null;
    }
}

public class LinkedList {
    public static void main(String[] args) throws Exception {
        ListNodeOperations<Integer> list = new ListNodeOperations<>();
        list.addFirst(5);
        ;
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);
        list.addFirst(4);
        list.addLast(11);
        list.addAtPos(10, 6);
        list.delFirst();
        list.deleteLast();
        list.deletAtPos(2);

        list.print();
    }
}






