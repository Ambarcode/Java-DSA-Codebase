package com.ak.Recursion;

public class PredictTheWinner {
    public static boolean predictTheWinner(int[] nums) {
        int tot = 0;
        for (int x : nums) {
            tot += x;
        }

        int score1 = find(0, nums.length - 1, nums, 1);
        int score2 = tot - score1;

        return score1 >= score2;
    }

    public static int find(int i, int j, int[] nums, int turn) {
        if (i > j) {
            return 0;
        }

        int val = 0;
        if (turn == 1) {
            val = Math.max(nums[i] + find(i + 1, j, nums, 1 - turn), nums[j] + find(i, j - 1, nums, 1 - turn));
        } else {
            val = Math.min(find(i + 1, j, nums, 1 - turn), find(i, j - 1, nums, 1 - turn));
        }

        return val;
    }

    public static void main(String[] args) {
        int[] arr={1,5,2};
        System.out.println(predictTheWinner(arr));
    }
}
