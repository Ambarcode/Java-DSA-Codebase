package com.ak.Arrays.ArrayQuestion;

public class MinimumSizeSubarraySum {
    //we can use the sliding Window approach
    //Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray
    // whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
    public int minSubArrayLen(int target, int[] nums) {
       int min=Integer.MAX_VALUE;
       int currSum=0;
       int left=0;
       int right=0;
        for (int i = 0; i <nums.length ; i++) {
            currSum+=nums[right];
            right++;
            while (currSum>=target){
                min=Math.min(min,right-left+1);
                currSum-=nums[left];
                left++;
            }
        }
        return min;

    }
}
