package com.ak.Queue;

import java.util.EmptyStackException;

public class CustomQueueCircularArray {
    //In this both the insertion and deletion will take O(1) time
    int [] arr;
    int capacity;
    int rear;
    int front;

    public CustomQueueCircularArray(int n){
        this.capacity=n;
        arr=new int[n];
        this.front=-1;
        this.rear=-1;

    }

    void enqueue(int data){
        //check queue is full or not
         if ((rear+1)%capacity==front) return;

         if (front==-1) front=0;  //empty queue check
         rear=(rear+1)%capacity;
         arr[rear]=data;
    }

    int deque(){
        if (front==-1) throw new EmptyStackException();
        int result=arr[front];
        if (front==rear){
            front=-1;
            rear=-1;
        }
        else {
            front=(front+1)%capacity;
        }
        return result;
    }
}
