package com.ak.Arrays.ArrayQuestion;

public class StockBuyAndSell {
    //we'll solve this by taking cumulative profit
    //if the value of arr[i]>arr[i-1] , we'll add the cumulative profit

    public static int maxProfit(int[] nums){
        int maxProfit=0;

        for (int i = 1; i <nums.length ; i++) {
            if (nums[i]>nums[i-1]){
                maxProfit+=nums[i]-nums[i-1];
            }
        }
        return maxProfit;
    }
}
