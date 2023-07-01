package com.ak.Arrays.BinarySearch;

import java.util.Arrays;

public class FirstAndLastIndex {
  private static int[] findFirstAndLast(int[] nums , int target){
      int low=0;
      int high=nums.length-1;
      int firstOccurrence=-1;
      int lastOccurrence=-1;


      //for first Occurrence
      while (low<=high){
          int mid=low+(high-low)/2;


          if (nums[mid]==target) {firstOccurrence=mid; high=mid-1;}
          else if (nums[mid]<target){
              low=mid+1;
          }
          else {
              high=mid-1;
          }
      }

      low=0;
      high=nums.length-1;

      //Now for the lastOccurrence
      while (low<=high){
          int mid=low+(high-low)/2;


          if (nums[mid]==target){ lastOccurrence=mid; low=mid+1;}
          else if (nums[mid]<target){
              low=mid+1;
          }
          else {
              high=mid-1;
          }
      }
      return new int[]{firstOccurrence,lastOccurrence};
  }

    public static void main(String[] args) {
        int[] arr={10,20,30,40,40,40,50,60,70};
        System.out.println(Arrays.toString(findFirstAndLast(arr,40)));
    }
}
