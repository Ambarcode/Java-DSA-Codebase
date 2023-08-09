package com.ak.Arrays.ArrayQuestion;

public class DutchNationalFlag {
    //can we solve this problem in O(n) time
    public void sortColors(int[] nums) {


        //Dutch National flag algo

        int j=0; //0 to j-1 -> 0's Area
        int i=0; //j to i-1 -> 1's Area
        int k=nums.length-1; //K+1 to end -> 2's Area

        // i to k is unknown
        while(i<=k){
            if(nums[i]==0){
                swap(nums, i , j);
                i++;
                j++;
            }
            else if(nums[i]==1){
                i++;
            }

            else{
                swap(nums,i,k);
                k--;
            }

        }

    }

    private int[] swap(int[] arr, int a , int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;

        return arr;
    }
}
