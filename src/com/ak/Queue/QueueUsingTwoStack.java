package com.ak.Queue;

import java.util.EmptyStackException;
import java.util.Stack;

public class QueueUsingTwoStack {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public QueueUsingTwoStack(){
        s1=new Stack<>();
        s2=new Stack<>();
    }

    void enqueue(int data){
        //no need to check that stack is full
        s1.push(data);
    }

    int deque(){
        if (s1.isEmpty()) throw new EmptyStackException();

        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }

        int elem=s2.pop();
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return elem;
    }

    int peek(){
        if (s1.isEmpty()) throw new EmptyStackException();

        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }

        int elem=s2.peek();
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return elem;
    }

    int size(){
        return s1.size();
    }


    public static void main(String[] args) {
        QueueUsingTwoStack qs=new QueueUsingTwoStack();
        qs.enqueue(1);
        qs.enqueue(2);
        qs.enqueue(3);
        //System.out.println(qs.deque());

    }

}
