package com.ak.Arrays.BinarySearch;

import java.util.Arrays;

public class NearestLowestAndGreatest {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50};
        int k = 5;
        System.out.println(Arrays.toString(findNLowestAndNGreatest(nums , k)));
    }

    private static int[] findNLowestAndNGreatest(int[] nums, int k) {
        int low=0;
        int high=nums.length-1;
        int nearestLowest=-1;
        int nearestHighest=-1;
        while (low<=high){
            int mid=low+(high-low)/2;

            if (nums[mid]==k){
                nearestLowest=nums[mid];
                low=mid+1;
            }
            else if (nums[mid]<k){
                nearestLowest=nums[mid];
                low=mid+1;
            }
            else {
                nearestHighest=nums[mid];
                high=mid-1;
            }
        }
        return new int[]{nearestLowest,nearestHighest};
    }
}
