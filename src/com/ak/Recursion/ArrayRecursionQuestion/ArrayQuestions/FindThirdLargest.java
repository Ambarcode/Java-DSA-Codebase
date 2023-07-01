package com.ak.Recursion.ArrayRecursionQuestion.ArrayQuestions;

public class FindThirdLargest {

    public static int findThirdLargest(int[] nums) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("Invalid input");
        }

        int firstLargest = nums[0];
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            if (num > firstLargest) {
                thirdLargest = secondLargest;
                secondLargest = firstLargest;
                firstLargest = num;
            } else if (num > secondLargest && num < firstLargest) {
                thirdLargest = secondLargest;
                secondLargest = num;
            } else if (num > thirdLargest && num < secondLargest) {
                thirdLargest = num;
            }
        }

        return thirdLargest;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 9, 1, 7, 6, 3, 8, 4};
        int thirdLargest = findThirdLargest(nums);
        System.out.println("Third largest element: " + thirdLargest);
    }
}

