package com.ak.Stacks;

import java.util.Deque;

import java.util.ArrayDeque;
 class CustomArrayDeque {

     //LinkedList vs ArrayDeque: https://web.archive.org/web/20191101213733/http://brianandstuff.com/2016/12/12/java-arraydeque-vs-linkedlist/

    //using ArrayDeque we can add from both front and last and similarly we can remove from both front and last , we can implement both stack and queue from arraydeque
    //Advantages of using ArrayDeque:
    //Efficient: The ArrayDeque class provides constant-time performance for inserting and removing elements from both ends of the queue, making it a good choice for scenarios where you need to perform many add and remove operations.
    //Resizable: The ArrayDeque class uses a resizable array to store its elements, which means that it can grow and shrink dynamically to accommodate the number of elements in the queue.
    //Lightweight: The ArrayDeque class is a lightweight data structure that does not require additional overhead, such as linked list nodes, making it a good choice for scenarios where memory is limited.
    //Thread-safe: The ArrayDeque class is not thread-safe, but you can use the Collections.synchronizedDeque method to create a thread-safe version of the ArrayDeque class.
    public static void main(String[] args) {
        Deque<Integer> dq=new ArrayDeque<>();
        dq.offerFirst(10);
        dq.offerFirst(20);
        dq.offerFirst(30);
        dq.offerFirst(40);


        //we can see here it works like Stack
        while (dq.size()>0){
            System.out.println(dq.pollFirst());
        }

    }

}
