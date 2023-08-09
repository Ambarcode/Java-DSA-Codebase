package com.ak.HashMapAndHeap;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity){
        this.capacity=capacity;
        heap=new int[capacity];
        this.size=0;
    }

    public int parent(int index){
        return (index-1)/2;
    }

    public int leftChild(int index){
        return (2*index+1);
    }

    public int rightChild(int index){
        return (2*index+2);
    }

    public void swap(int i , int j){
        int temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }

    //insertion in heap
    public void insert(int value){
        //overflow condition check
        if (size==capacity) {
            System.out.println("Heap is full");
            return;
        }
        int curr=size;
        heap[size++]=value;

        //check whether the parent is smaller and if not swap
        while (curr>0 && heap[curr]<heap[parent(curr)]){
            //we need to swap the current and parent pointer
            swap(curr,parent(curr));
            //check whether the parent of parent is also greater
            curr=parent(curr);
        }
    }

    //deletion in heap
    public int delete(){
        if (size==0){
            System.out.println("Heap is Empty");
            return -1;
        }
        int x=heap[0];
        heap[0]=heap[--size];

        //now we have to maintain our min heap
        heapify(0);
        return x;
    }

    private void heapify(int index){
        int parent=index;


        int lci=leftChild(index);
        int rci=rightChild(index);

        if (lci<size && heap[lci]<heap[parent]){
            parent=lci;
        }
        if (rci<size && heap[rci]<heap[parent]){
            parent=rci;
        }
        //if swapping occurs
        if (parent!=index){
            swap(parent,index);
            heapify(parent);
        }
    }

    private void print(){
        for (int i = 0; i < size; i++) {
            System.out.println(heap[i]);
        }
    }
    public int size(){
        return size;
    }

    public static void main(String[] args) {
      MinHeap heap=new MinHeap(5);
      heap.insert(3);
      heap.insert(0);
      heap.insert(1);
      heap.insert(2);
      heap.delete();
      heap.print();

    }

}
