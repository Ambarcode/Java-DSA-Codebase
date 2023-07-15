package com.ak.Stacks;

import java.util.Stack;

public class SortStack {
    //Given a stack f integers , sort it using another stack
    private static Stack<Integer> sort(Stack<Integer> st){

        //create a Temporary Stack
        Stack<Integer> temp=new Stack<>();
        temp.push(st.pop());
        while (!st.isEmpty()){
            int elem=st.pop();
            while (!temp.isEmpty() && elem>temp.peek()){
                st.push(temp.pop());
            }
            //push the current element on to the stack
            temp.push(elem);
        }

        return temp;
    }


    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

       Stack<Integer> temp=sort(st);
       while (!temp.isEmpty()){
           System.out.println(temp.pop());
       }

    }
}
