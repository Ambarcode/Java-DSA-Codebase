package com.ak.Arrays.ArrayQuestion;

import java.util.Arrays;

public class PreComputation {
    //suppose we had provided an N size array
    //we have to do certain data fetching queries
    //for ex: query1: find the sum from index 1 to index 4
    //Query2: find the sum from 0 index to 5th index;


    //Problem : We had an N size array, and we had N queries , then it will take N*Q , where N is the traversal for N elements and Q is the query

    //How to solve: we'll use PrefixSum and SuffixSum Approach

    //Thought Process:arr[i]=arr[i]+arr[i-1]
    //Though this we;ll easily be able to calculate sum

    private static int[] prefixSum(int[] nums){

        for (int i = 1; i < nums.length ; i++) {
            nums[i]=nums[i]+nums[i-1];
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] arr={10,20,30,40,50,60,70,80,90,100};
        int[] ans=prefixSum(arr);
        System.out.print("Prefix Array----> ");
        System.out.println(Arrays.toString(ans));
    }
}
