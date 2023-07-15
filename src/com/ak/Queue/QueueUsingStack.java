package com.ak.Queue;

import java.util.EmptyStackException;
import java.util.Stack;

public class QueueUsingStack {
    //we are provided with a stack we have to use it to implement a queue
   //we just use recursion to do it with single stack , however internally , it's the system stack only
    Stack<Integer> s1;

    void enqueue(int data){
        s1.push(data);
    }

    int deque(){
        if (s1.size()==0) throw new EmptyStackException();

        //base case , we have to return the lowermost element
        if(s1.size()==1) return s1.pop();
        int data=s1.pop();
        int val=deque();
        s1.push(data);
        return val;
    }

}
