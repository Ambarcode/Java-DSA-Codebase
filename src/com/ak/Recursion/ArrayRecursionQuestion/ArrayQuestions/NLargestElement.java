package com.ak.Recursion.ArrayRecursionQuestion.ArrayQuestions;

import java.util.PriorityQueue;

public class NLargestElement {
    public static int findNthLargest(int[] nums, int n) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);

            if (minHeap.size() > n) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 9, 1, 7, 6, 3, 8, 4};
        int n = 3;
        int nthLargest = findNthLargest(nums, n);
        System.out.println("Nth largest element: " + nthLargest);
    }
}
