package com.ak.BitManipulation;

public class MaximumANDValueInAnArray {
    //Approach 1: Naive Approach : use two loops
    //Time Complexity O(n^2)
    private static int maximumBitwiseAnd(int[] arr){
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j <arr.length; j++) {
                max=Math.max(arr[i]&arr[j],max);
            }
        }
        return max;
    }

    //Approach 2: Using Bit Manipulation
//    Initialize the result (res) as 0.
//
//    Iterate over each bit position from the most significant bit (MSB) to the least significant bit (LSB).
//
//    For each bit position, check if setting that bit in res and performing an AND operation with each element in the array results in at least two elements having the same pattern as res at that bit position.
//
//    Use the checkBit function to count the number of elements in the array that have the same pattern as the one obtained by setting the current bit in res.
//
//    If the count is greater than or equal to 2, update res by setting the current bit.
//
//    Repeat steps 3 to 5 for all the bit positions, from MSB to LSB.
//
//    At the end, res will contain the maximum AND value that can be obtained by taking a pair of elements from the array.
    private static int maximizeAnd(int[] arr){
        int ans=0;
        for(int i=31;i>0;i--) {
            if (findForSimilarSetBitPattern((ans|(1<<i)),arr)>=2){
                ans|=(1<<i);
            }
        }
        return ans;
    }

    private static int findForSimilarSetBitPattern(int pattern , int[] arr){
        int count=0;
        for (int j : arr) {
            if ((pattern & j) == pattern) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr={4, 8, 16, 2};
        System.out.println(maximizeAnd(arr));
    }


}
