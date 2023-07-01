package com.ak.Arrays.ArrayQuestion;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    //Approach 1 : Use HashSet
    //Approach 2: Use Two Pointer Approach

    public static int[]  removeDuplicates(int[] nums){
      int j=0;
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]!=nums[j]){
                j++;
                nums[j]=nums[i];
            }
        }
        return Arrays.copyOfRange(nums , 0 , j+1);
    }

    public static void main(String[] args) {
        int[] nums={1,1,2,3,3,3,4,4,5,5,5,5,5,6};
        int[] ans=removeDuplicates(nums);
        System.out.println(Arrays.toString(ans));
    }
}
