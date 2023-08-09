package com.ak.Arrays.ArrayQuestion;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithZeroSum {
    public static boolean hasZeroSumSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for (int num : nums) {
            sum += num;

            if (num == 0 || sum == 0 || set.contains(sum)) {
                return true;
            }

            set.add(sum);
        }

        return false;
    }
}

 class Main {
    public static void main(String[] args) {
        int[] nums = {4, 2, -3, 1, 6};
        boolean hasZeroSum = SubArrayWithZeroSum.hasZeroSumSubarray(nums);
        System.out.println(hasZeroSum ? "Subarray with 0 sum exists." : "Subarray with 0 sum does not exist.");
    }

}
