package com.ak.HashMapAndHeap;

public class KthElementOfTwoSortedArray {
    //There are multiple approaches to solve the problem
    //One Such Approach is to maintain two pointers and make which take O(K) time complexity and O(1) space complexity
    //However we'll look into another approach which uses binary search
    //In this our binary search will work on how many elements we are taking from the array
    //What is the minimum element , I can take from the array 1

    //low=0 , hig=k-1
    //well take a couple of elements from arr1 and rest from arr2
    //the condition should be l1<=r2 and l2<=r1
    //if the condition didn't satisfy we'll update our low and high
    //if both the condition satisfy(l1<=r2 and l2<=r1) we'll find the max of l1 and l2, and we get our answer
    //We can part it in such a way that our kth element will be at the end of the left half array. Let’s make some observations. The left portion of the array is made of some elements of both array1 and array2. We can see that all elements of the right half of the array are always larger than the left ones. So, with help of binary search, we will divide arrays into partitions with keeping k elements in the left half. We have to keep in mind that l1 <= r2 and l2 <= r1. Why so? This ensures that left-half elements are always lesser than right elements.
    static int kthelement(int arr1[], int arr2[], int m, int n, int k) {
        if(m > n) {
            return kthelement(arr2, arr1, n, m, k);
        }

        int low = Math.max(0,k-m), high = Math.min(k,n);

        while(low <= high) {
            int cut1 = (low + high) >> 1;
            int cut2 = k - cut1;
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2];

            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            else if (l1 > r2) {
                high = cut1 - 1;
            }
            else {
                low = cut1 + 1;
            }
        }
        return -1;
    }
}








