package com.ak.HashMapAndHeap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
//for sorting value pairs in ascending oder
//PriorityQueue<Map.Entry<String, Integer>> entryPriorityQueue = new PriorityQueue<>(
//        (entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())
//);

//for sorting value pairs in descending order
//  PriorityQueue<Map.Entry<String, Integer>> entryPriorityQueue = new PriorityQueue<>(
//                (entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())
//        );
public class KthMostOccurring{
    //The approach is to use hashmap and maxheap
    private static int solve(int[] arr, int k){
        //Creating a hashmap which stores element based on their frequency
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int elem: arr){
            map.put(elem,map.getOrDefault(elem,0)+1);
        }
        if (map.size()==0) return -1;

        //Now creating a Heap which will store the frequencies in descending order
        PriorityQueue<Map.Entry<Integer, Integer>> entryPriorityQueue = new PriorityQueue<>(
                (entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())
        );
        entryPriorityQueue.addAll(map.entrySet());

        for (int i=0;i<k-1;i++){
            entryPriorityQueue.poll();
        }
        return entryPriorityQueue.poll().getKey();
    }

    public static void main(String[] args) {
        int[] arr={3,4,5,5,5,3,8,7,7,7,7};
        System.out.println(solve(arr,2));
    }
}
