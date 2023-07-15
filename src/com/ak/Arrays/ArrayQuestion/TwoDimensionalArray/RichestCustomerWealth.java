package com.ak.Arrays.ArrayQuestion.TwoDimensionalArray;

public class RichestCustomerWealth {
    public static int maximumWealth(int[][] accounts) {
        int ans=Integer.MIN_VALUE;
        for(int[] person: accounts){
            int sum=0;
            for(int account: person){
                sum+=account;
            }
            if(sum>ans){
                ans=sum;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
