package com.ak.Stacks;

import java.util.EmptyStackException;

public class ImplementTwoStackUsingSingleArray {
    //the approach is to fill the array from both  ends
     private int[] stack;
     private int top1;
     private int top2;



     public ImplementTwoStackUsingSingleArray(int capacity){
         stack=new int[capacity];
         this.top1=-1;
         this.top2=capacity;
     }


     void push1(int elem){
         if (top1<top2-1){
             stack[++top1]=elem;
         }
         else {
             System.out.println("Stack Overflow");
             System.exit(1);
         }
     }

    void push2(int elem){
        if (top2>top1+1){
            stack[--top2]=elem;
        }
        else {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }

    int pop1(){
         if (top1>=0){
             int elem=stack[top1];
             top1--;
             return elem;
         }
         else {
             System.out.println("Stack Underflow");
             System.exit(1);
         }
        return 0;
    }

    int pop2(){
        if (top2<stack.length){
            int elem=stack[top2];
            top1++;
            return elem;
        }
        else {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }

    int peek1(){
         if (top1==-1) {
                 System.out.println("Stack Underflow");
                 System.exit(1);
         }
         return stack[top1];
    }

    int peek2(){
        if (top2==stack.length){
                System.out.println("Stack Underflow");
                System.exit(1);
            return 0;
        }
        return stack[top2];
    }

    boolean isEmpty1(){
         return top1==-1;
    }

    boolean isEmpty2(){
        return top2==stack.length;
    }

    public static void main(String[] args) {
        ImplementTwoStackUsingSingleArray twoStack=new ImplementTwoStackUsingSingleArray(10);
        twoStack.push1(1);
        twoStack.push2(2);
        twoStack.push2(3);
        twoStack.push1(4);
    }
}
