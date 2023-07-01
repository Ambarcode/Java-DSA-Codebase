package com.ak.Arrays.ArrayQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairWithSmallestSum {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> resV = new ArrayList<>(); // Result list to store the pairs
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int x : nums1) {
            pq.offer(new int[]{x + nums2[0], 0}); // The sum and the index of the second element in nums2
            if(pq.size()==k) break;
        }
        // Pop the k  smallest pairs from the priority queue
        while (k > 0 && !pq.isEmpty()) {
            int[] pair = pq.poll();
            int sum = pair[0]; // Get the smallest sum
            int pos = pair[1]; // Get the index of the second element in nums2

            List<Integer> currentPair = new ArrayList<>();
            currentPair.add(sum - nums2[pos]);
            currentPair.add(nums2[pos]);
            resV.add(currentPair); // Add the pair to the result list

            // If there are more elements in nums2, push the next pair into the priority queue
            if (pos + 1 < nums2.length) {
                pq.offer(new int[]{sum - nums2[pos] + nums2[pos + 1], pos + 1});
            }

            k--; // Decrement k
        }

        return resV; // Return the k smallest pairs



    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println(BinarySearch(arr,40));
    }

    public static int BinarySearch(int[] arr , int target){
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + (high - low) / 2);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high=mid-1;
            }
        }
       return -1;
    }
}

