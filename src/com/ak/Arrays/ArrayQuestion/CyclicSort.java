package com.ak.Arrays.ArrayQuestion;

import java.util.Arrays;

public class CyclicSort {

    public static void main(String[] args) {
        int[] arr={5,3,2,4,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void sort(int[] nums){
        int i=0;
        while (i<nums.length){
            int correct=nums[i]-1;
            if (nums[i]!=nums[correct]){
                swap(nums , i , correct);
            }
            else i++;
        }
    }

    private static void swap(int[] nums , int first , int second){
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }
}
