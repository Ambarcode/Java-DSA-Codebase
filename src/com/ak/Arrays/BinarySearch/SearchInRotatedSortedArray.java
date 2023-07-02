package com.ak.Arrays.BinarySearch;

import java.util.Collections;

public class SearchInRotatedSortedArray {
    //Approach 1: Using Binary Search

    private static int pivot(int[] arr) {
        //find the pivot
        //before and after the array is sorted
        //Search in first half , otherwise search in second half
        //but how to find the pivot

        // let's take an example
        //arr={3,4,5,6,7,0,1,2};
        //which condition is for pivot
        //there will be only a single point in the array , where it is descending
        //Case 1: when my middle is greater than mid+1, pivot found(mid>mid+1)
        //Case 2: if mid <mid-1 , then we have found the pivot
        //Case 3: if start>=mid then all the elements after the mid will be less than start , as the array is rotated and sorted , so we will ignore them as they are less than peak
        //Case 4: if start<=mid then all the elements before the mid will be less than mid , as the array is rotated , so we'll make start=mid+1

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + (end - start) / 2);

            //4 cases;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
          return -1;
    }
    private static int solve(int [] arr, int target){
        int pivot=pivot(arr);
        //if you didn't find pivot , the array is not rotated
        if(pivot==-1){
            //just do normal binary search
            return binarySearch(arr,target,0, arr.length-1);
        }
        if(arr[pivot]==target) return pivot;

        if (target>=arr[0]) return binarySearch(arr,target,0, pivot-1);

        return binarySearch(arr,target,pivot+1,arr.length-1);
    }
    public static int binarySearch(int[] array, int target, int left , int right) {


        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; // Target element found, return the index
            } else if (array[mid] < target) {
                left = mid + 1; // Target element is in the right half
            } else {
                right = mid - 1; // Target element is in the left half
            }
        }

        return -1; // Target element not found in the array
    }

    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,1,2};
       // System.out.println(pivot(arr));
        System.out.println(solve(arr,0));
    }
}

