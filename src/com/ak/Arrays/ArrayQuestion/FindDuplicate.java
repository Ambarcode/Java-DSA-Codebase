package com.ak.Arrays.ArrayQuestion;

import java.util.HashMap;

public class FindDuplicate {
 //there are multiple approaches to find the duplicate in array

    //Check: We can't modify the original array

    //Approach 1: marking the index of each number visited to be -1 . such that when the number repeats  its index is already -1
    private static int findDuplicate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int index=Math.abs(nums[i])-1;
            if (nums[index]<0){
               return Math.abs(nums[i]);
            }
            else {
                nums[index]=-nums[index];
            }
        }
        return -1;
    }

    //Another Approach using Hashmap or Hashset
    private static int findDuplicate2(int[] nums){
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {

           if (map.containsKey(nums[i])){
               return nums[i];
           }
           else{
               map.put(nums[i],i);
           }
        }
        return -1;
    }

    //Another Approach: Hare Approach , Floyd Cycle Detection(Similar to linked list cycle detection)


    private static int findDuplicate3(int[] nums){
        int fast=0;
        int slow=0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Reset the slow pointer to the start
        slow = nums[0];

        // Move both pointers until they meet again
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        // Return the duplicate number
        return slow;

    }

    public static void main(String[] args) {
        int[] arr={1,3,4,2,2};
        int ans=findDuplicate3(arr);
        System.out.println(ans);
    }
}
