package com.ak.HashMapAndHeap;

public class KthLargest {
    public static void main(String[] args) {
        int[] arr={2,3,4,9,23,9,8,66};
        int k=2;
        MinHeap heap=new MinHeap(arr.length);
        for (int i=0;i<arr.length;i++){
            heap.insert(arr[i]);

            if (heap.size()>k){
                heap.delete();
            }
        }
        System.out.println(heap.delete());

    }
}
