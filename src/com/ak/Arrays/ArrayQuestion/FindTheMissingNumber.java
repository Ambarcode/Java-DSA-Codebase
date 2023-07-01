package com.ak.Arrays.ArrayQuestion;

import com.ak.Arrays.ArrayQuestion.Sortng.CyclicSort;

public class FindTheMissingNumber {

    //1st Approach: Calculated the expected sum-total sum , you'll get your missing number
    public static int missingNumber(int[] array, int n) {

        int totalSum = (n * (n + 1)) / 2; // Calculate the sum of numbers from 0 to n

        int arraySum = calculateSum(array, 0); // Calculate the sum of elements in the array recursively

        return totalSum - arraySum; // Subtract the array sum from the total sum to find the missing number

    }
    private static int calculateSum(int[] nums, int index) {
        if (index == nums.length) {
            return 0; // Base case: If we reach the end of the array, return 0
        } else {
            return nums[index] + calculateSum(nums, index + 1); // Recursively calculate the sum of remaining elements
        }
    }

    //2nd Approach : use cyclic sort
     public static int findMissing(int[] nums){
         sort(nums);
         for (int index  = 0; index <nums.length ; index++) {
             if (nums[index]!=index+1) return index+1;
         }
         return -1;
     }

    public static void sort(int[] nums){
        int i=0;
        while (i<nums.length){
            int correct=nums[i]-1;
            if (nums[i]<nums.length && nums[i]!=nums[correct]){
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

    //3rd Approach :- Using Hare Cycle Detection
    public static int findMissingNumber(int[] nums) {
        int tortoise = nums[0]; // Starting point for tortoise
        int hare = nums[0]; // Starting point for hare

        // Move hare by 2 steps and tortoise by 1 step until they meet
        do {
            tortoise = nums[tortoise]; // Tortoise moves 1 step
            hare = nums[nums[hare]]; // Hare moves 2 steps
        } while (tortoise != hare);

        // Reset the hare to the starting point
        hare = nums[0];

        // Move hare and tortoise at the same speed until they meet
        while (tortoise != hare) {
            tortoise = nums[tortoise]; // Tortoise moves 1 step
            hare = nums[hare]; // Hare moves 1 step
        }

        // At this point, hare and tortoise meet at the starting point of the cycle
        // which is also the missing number
        return hare;
    }


    public static void main(String[] args) {
        int[] arr={1,2,3,5};
        System.out.println(findMissing(arr));
    }
}
