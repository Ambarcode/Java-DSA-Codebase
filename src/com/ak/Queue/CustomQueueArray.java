package com.ak.Queue;

import java.util.EmptyStackException;

public class CustomQueueArray {
     int[] arr;
     int capacity;
     int rear;
     int size;

     public CustomQueueArray(int n){
         this.capacity=n;
         arr=new int[capacity];
         this.rear=-1;
         this.size=0;
     }

     void enqueue(int data){
         //check if the queue is full
         if (rear==capacity-1) throw new RuntimeException();
         arr[++rear]=data;
         size+=1;
     }

     int dequeue(){
         //Complexity: O(N)
         //if queue is null
         if (rear==-1)  throw new EmptyStackException();
        //we have to swift the elements after removal
         int result=arr[0];
         for (int i = 0; i <rear ; i++) {
             arr[i]=arr[i+1];
         }
         rear--;
         size--;
         return result;
     }

     int getFront(){
         if (rear==-1) throw new EmptyStackException();
         return arr[0];
     }

     boolean isEmpty(){
         return size<=0;
     }

     int size(){
         return size;
     }
}
