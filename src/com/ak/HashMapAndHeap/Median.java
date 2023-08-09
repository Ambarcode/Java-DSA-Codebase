package com.ak.HashMapAndHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Median {
    //We have to find the median of the array using heap
    //we'll maintain two heap
    //A min heap and max heap
    //whenever the size of min heap will get greater than max heap we'll remove the element from min heap and add it to max heap
    //if size of both the heap will become same , we'll pop both the elements from the heap and divide it by two , we'll get our answer
    //else we'll return the top element of max heap
    static PriorityQueue<Integer> maxHeap;
    static PriorityQueue<Integer> minHeap;
    private static double medianFinder(int[] arr){
        //traverse the whole array
        for (int elem: arr){
            if (maxHeap.isEmpty() || maxHeap.peek()>=elem ){
                maxHeap.add(elem);
            }
            else minHeap.add(elem);

            //check whether they are balanced or not
            if (maxHeap.size()>minHeap.size()+1){
                minHeap.offer(maxHeap.poll());
            }
            else if (minHeap.size()>maxHeap.size()){
                maxHeap.offer(minHeap.poll());
            }
        }

        //we'll check whether both queues are having equal size or not
        if (maxHeap.size()==minHeap.size()) return (double) (maxHeap.peek()+maxHeap.peek()/2);
        else return maxHeap.peek();
    }

    public static void main(String[] args) {
        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        minHeap=new PriorityQueue<>();
        int[] arr={3,2,4,1,5};
        System.out.println(medianFinder(arr));
    }

}

