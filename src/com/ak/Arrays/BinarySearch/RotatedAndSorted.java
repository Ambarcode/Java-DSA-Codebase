package com.ak.Arrays.BinarySearch;

public class RotatedAndSorted {
    //'we have to check whether the array is sorted and rotated
    public static boolean check(int[] arr) {
        //one Approach should be to find the minimum element using binary search and around that we'll check both half is sorted or not , we also have to take care of arr[n-1]<arr[0]
        //another approach linear search , and check if there are multiple breakpoints
        if(arr.length<2) return true;
        int count=0;

        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]) count++;
        }

        //for last and first element

        if(arr[arr.length-1]>arr[0]){
            count++;
        }
        return count<=1;
    }
}
