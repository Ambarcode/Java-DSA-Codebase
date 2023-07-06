package com.ak.Arrays.ArrayQuestion;

public class MaximumNumUpToARange {
    //for a given range in an array , we are provided to find the maximum number from it
    private static int maxInRange(int[] arr , int k){
        int[] prefixSum=new int[arr.length];
        prefixSum[0]=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            prefixSum[i]=Math.max(prefixSum[i-1],arr[i]);
        }
        if (k<=arr.length-1)
        return prefixSum[k];
        else return -1;
    }

    public static void main(String[] args) {
        int[] arr={5,-1,0,2,3,7};
        System.out.println(maxInRange(arr,5));
    }
}
