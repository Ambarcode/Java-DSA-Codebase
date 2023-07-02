package com.ak.Arrays.ArrayQuestion;

public class MaximumSubArraySum {
    //One approach should be to generate all subarray , take a max variable to store the maximum sum

    private static int maximumSubArraySum(int[] arr){
        //we'll take a max variable ,  for each subArray we'll update the max variable

        int max=Integer.MIN_VALUE;
        for (int i = 0; i <arr.length ; i++) {
            int sum=0;
            for (int j=i;j<arr.length;j++) {
                sum += arr[j];
                max = Math.max(sum, max);
            }
        }
        return max;
        }

        //Optimized Approach : Kadane's Algorithm
        private static int kadaneAlgorithm(int[] arr){
             int max=Integer.MIN_VALUE;
             int sum=0;
            for (int j : arr) {
                sum += j;

                //compare with maximum
                max = Math.max(sum, max);

                //Is it beneficial to take current element forward(sum>0)
                if (sum < 0) sum = 0;
            }

             return Math.max(max, 0);
        }

    public static void main(String[] args) {
        int[] arr={-3, -4, 5, -1, 2, -4, 6, -1};
        System.out.println(kadaneAlgorithm(arr));
    }

    }


