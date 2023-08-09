package com.ak.HashMapAndHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < stones.length; i++) q.offer(stones[i]);
        while(q.size() > 1) {
            q.offer(q.poll()-q.poll());
        }
        return q.isEmpty()?0:q.poll();
    }
}
