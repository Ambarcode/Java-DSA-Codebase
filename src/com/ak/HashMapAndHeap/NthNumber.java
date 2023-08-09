package com.ak.HashMapAndHeap;

import java.util.PriorityQueue;
 //finding the nth number that is divisible by either 2, 3, or 5.
public class NthNumber {
    private static int solve(int count){
        //upto number 6 the value of count is the kth number which is divisible by wither 2 , 3 or 5
        if (count>=6) return count;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        minHeap.add(1);
        for (int i = 1; i <count ; i++) {
            int current=minHeap.poll();
            while (!minHeap.isEmpty() && minHeap.peek()==current){
                current=minHeap.poll();
            }
            minHeap.add(current*2);
            minHeap.add(current*3);
            minHeap.add(current*5);
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int n=10;
        System.out.println(solve(10));
    }
}
