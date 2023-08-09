package com.ak.HashMapAndHeap;

import java.util.PriorityQueue;

public class MinCostRopes {
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n)
    {
        PriorityQueue<Long> queue=new PriorityQueue<>();
        for(long elem:arr) queue.offer(elem);
        if(queue.size()<2) return 0;
        long cost=0;
        while(queue.size()!=1){
            long elem1=queue.poll();
            long elem2=queue.poll();
            long sum=elem1+elem2;
            cost+=sum;
            queue.offer(sum);
        }
        return cost;
    }
}
