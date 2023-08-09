package com.ak.Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryNumberUpToN {
    //using queue we have to generate binary number up to n
    //The approach is to initially push 1
    //We'll run a loop which will add 1 and 0 to it and then push both 0f them to queue and repeat the process
    static void printBinary(int n){
    Queue<String> queue=new ArrayDeque<>();
    queue.offer("1");
    while (n!=0){
        String elem=queue.peek();
        System.out.println(elem);

        String elem1=elem+"0";
        String elem2=elem+"1";

        queue.offer(elem1);
        queue.offer(elem2);
        n--;

    }
    }
}
