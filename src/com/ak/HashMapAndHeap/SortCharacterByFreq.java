package com.ak.HashMapAndHeap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharacterByFreq{
    //first we have to store elements based on their count , then we have to sort them according to their count value
    //For this we'll use MAx heap and Map

    private static String countByFreq(String str){
        Map<Character,Integer> map=new HashMap<>();
        for(char c: str.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        //Now we;ll make a Priority Queue which will sort the map based on frequency
        PriorityQueue<Character> queue=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        queue.addAll(map.keySet());
        StringBuilder sb=new StringBuilder();
        while (!queue.isEmpty()){
            //map.get(queue.poll());
            char c=queue.poll();
            int freq=map.get(c);
            for (int i=0;i<freq;i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
