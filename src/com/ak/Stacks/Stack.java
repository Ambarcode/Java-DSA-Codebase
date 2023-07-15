package com.ak.Stacks;


import java.util.EmptyStackException;

public class Stack{
     private int[] arr;
     private int size;
     private int top;

    public Stack(int capacity){
        arr=new int[capacity];
        this.top=-1;
        this.size=0;
    }

    public void push(int elem){
        if(isFull()) throw new StackOverflowError();
        top++;
        arr[top]=elem;
        size++;
    }
    public int pop(){
        if (isEmpty()) throw new EmptyStackException();
        int elem=arr[top];
        top--;
        size--;
        return elem;
    }

    private void print(Stack st){
        int value=st.top;
        while (value!=-1) {
            System.out.print(st.arr[value]+" ");
            value--;
        }
        System.out.println();
    }

    private boolean isEmpty() {
        return top==-1;
    }

    public boolean isFull(){
        return top==arr.length;
    }
    public static void main(String[] args) {
        Stack stack=new Stack(25);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.print(stack);
        int elem=stack.pop();
        stack.print(stack);
        stack.push(100);
        stack.print(stack);

    }
}
