package com.ak.Arrays.ArrayQuestion;

import java.util.Arrays;

public class ReverseAnArray {
    public static void reverse(int[] nums){
        //we'll use the two pointer approach to reverse an array

        if (nums.length<2) return;

        int start=0;
        int end=nums.length-1;

        while(start<=end){
            if (nums[start]==nums[end]) {start++; end--; continue;}
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    private static void swap(int[] arr , int i , int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,2,1};
        reverse(nums);
        System.out.println(Arrays.toString(nums));
    }
}
