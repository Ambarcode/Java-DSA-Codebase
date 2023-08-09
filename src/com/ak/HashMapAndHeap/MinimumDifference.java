package com.ak.HashMapAndHeap;

import java.util.PriorityQueue;

public class MinimumDifference {
    //given an array we have to find the minimum difference between two elements in an array
    private static int minDifference(int[] arr){
        //to find the minimum difference ,we'll use a min heap
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int elem: arr){
            queue.offer(elem);
        }

        int min=Integer.MAX_VALUE;
        int val=queue.isEmpty()?0:queue.poll();
        while (!queue.isEmpty()){
            int val2=queue.poll();
            int diff=val2-val;
            min=Math.min(diff,min);
            val=val2;
        }
        if (min==Integer.MIN_VALUE) min=0;
        return min;
    }

    public static void main(String[] args) {
        int[] arr={30, 5, 20, 9};
        System.out.println(minDifference(arr));
    }
}
