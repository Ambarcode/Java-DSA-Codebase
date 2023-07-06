package com.ak.Arrays.ArrayQuestion;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubset {
    public static List<List<Integer>> subsets(int[] nums) {
        //we can take the help of helper function
        List<List<Integer>> subsets=new ArrayList<>();
        generateSubsetsHelper(nums, new ArrayList<>(), subsets, 0);
        return subsets;
    }

    //helper function
    static void generateSubsetsHelper(int[] nums, List<Integer> current, List<List<Integer>> subsets, int index) {
        if (index == nums.length) {
           // System.out.println(current);
            subsets.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        generateSubsetsHelper(nums, current, subsets, index+1); // exclude the current element
        current.remove(current.size()-1);
        generateSubsetsHelper(nums, current, subsets, index+1); // include the current element
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);

        // Print the subsets
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
