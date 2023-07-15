package com.ak.Arrays.ArrayQuestion;

import java.util.Arrays;
import java.util.HashMap;

public class NoSmallerThanTheCurrentNumber {
    //Naive approach is to check for each number and count the number of elements less than it
    //however this approach is not efficient as it gives a Time Complexity of O(N^2)
    //Using Hashmap store the elements as key and index as pairs
    //Now maintain a copy of original array and sort the array
    //traverse the original array and for each element , look into the hashmap and store the array position with the corresponding value pair of the hashmap
    public int[] smallerNumbersThanCurrent(int[] nums) {
        //Input: nums = [8,1,2,2,3]
        //Output: [4,0,1,1,3]
        int[] newArr = nums.clone();
        Arrays.sort(newArr);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < newArr.length; i++) {
            map.putIfAbsent(newArr[i], i); //to avoiding overriding of duplicate value's index'
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.get(nums[i]);

        }
        return nums;
    }

    //Another Approach: Based on PrefixSum Approach
    public int[] smallerNumbersThanCurrentUsingPrefixSumApproach(int[] nums) {
        int[] hash = new int[101];

        //As the constraints are: 0 <= nums[i] <= 100
        //So we'll create an array of size 101 in which indices correspond to the element in the array we have been provided with
        for (int num : nums) {
            if (hash[num] != 0) {
                hash[num] = hash[num] + 1;
            } else {
                hash[num] = 1;
            }
        }
        //for array:- nums[8,1,2,2,3]
        //[0,1,2,1,0,0,0,0,1]
        //now in the hash array , we'' create its prefix sum
        for (int i = 1; i <hash.length ; i++) {
            hash[i]=hash[i]+hash[i-1];
        }


        //now we'll store the occurrence of number which are smaller than the current number in the original array
        for (int i = 0; i <nums.length; i++) {
            if(nums[i]==0){nums[i]=0; continue;}
            nums[i]=hash[nums[i]-1];
        }
        return nums;

    }
}
