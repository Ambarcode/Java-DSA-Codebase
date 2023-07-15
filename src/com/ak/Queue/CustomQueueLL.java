package com.ak.Queue;

class Node {
    int data;
    Node next;

    Node() {
        this.data = 0;
        this.next = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}


    class CustomQueueOperations {
    Node front , rear ;
    int size=0;
    //rear se daalo , front se nikaalo
    //As it follows a FIFO order
    void enqueue(int data) {
        //enqueue
        Node node = new Node(data);
        if ( front == null) {  //it means queue is empty
            front = node;
            rear= node;
            size++;
            return;
        }

        rear.next=node;
        rear=node;
        size++;
    }

    int dequeue(){
        //remove
        if (front==null) throw new RuntimeException();
        int data=front.data;
        front=front.next;
        size--;
        return data;
    }

    int size(){
        //to get the size of queue
        return size;
    }

    void display(){
        if (front==null) System.out.println("NULL");

        Node curr=front;
        while (curr!=null){
            System.out.print(curr.data+" ");
           curr=curr.next;
        }
        System.out.println();
    }

    int peek(){
        if (front==null) throw new RuntimeException();
        return front.data;
    }
}
public class CustomQueueLL {
    public static void main(String[] args) {
        CustomQueueOperations op=new CustomQueueOperations();
        op.enqueue(10);
        op.enqueue(20);
        op.enqueue(30);
        op.enqueue(40);
        op.enqueue(50);
        op.display();
        op.dequeue();
        op.dequeue();
        op.dequeue();
        op.display();
        System.out.println(op.peek());
        System.out.println(op.size);
    }
}
