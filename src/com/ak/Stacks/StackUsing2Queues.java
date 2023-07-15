package com.ak.Stacks;

import java.util.ArrayDeque;
import java.util.EmptyStackException;
import java.util.Queue;

//In this approach deque operation is costly , we also have another approach where we can make the enqueue consly
public class StackUsing2Queues {
     Queue<Integer> q1;
     Queue<Integer> q2;

     public StackUsing2Queues(){
         q1=new ArrayDeque<>();
         q2=new ArrayDeque<>();
     }

     void push(int data){
         while(!q1.isEmpty()){
             q2.offer(q1.poll());
         }
         q1.offer(data);
         while (!q2.isEmpty()){
             q1.offer(q2.poll());
         }
     }

     int pop(){
         if (q1.isEmpty()) throw new EmptyStackException();
         return q1.poll();
     }
    int peek(){
        if (q1.isEmpty()) throw new EmptyStackException();
        return q1.peek();
    }

    public static void main(String[] args) {
        StackUsing2Queues sq=new StackUsing2Queues();
        sq.push(10);
        sq.push(20);
        sq.push(30);
        sq.push(40);

        System.out.println(sq.pop());
        System.out.println(sq.pop());
        System.out.println(sq.pop());
        System.out.println(sq.pop());
    }
}
