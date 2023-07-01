package com.ak.Arrays.ArrayQuestion;

import java.util.Arrays;

public class ZigZagArray {
      public static void zigZag(int[] nums){
          boolean flag=true;

          for (int i = 0; i < nums.length-1 ; i++) {
              if (flag){
                  if (nums[i]>nums[i+1]) {
                      swap(nums, i, i+1);
                  }
              }
              else {
                  if (nums[i]<nums[i+1]) {
                      swap(nums, i, i + 1);
                  }
              }
              flag=!flag;
          }
      }
    private static void swap(int[] arr , int i , int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] nums={4,3,7,8,6,2,1};
        zigZag(nums);
        System.out.println(Arrays.toString(nums));
    }
}
