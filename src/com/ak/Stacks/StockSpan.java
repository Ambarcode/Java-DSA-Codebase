package com.ak.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
   //The span of the stock's price on a given day is defined as the maximum number of consecutive days (including the current day) prior to the given day,
    // for which the stock price is less than or equal to the price on the given day.
    //Stock Prices: [100, 80, 60, 70, 60, 75, 85]
    //Stock Spans:  [  1,  1,  1,  2,  1,  4,  6]


    //Approach 1: Iterative approach
    private static int[] stockSpanIterative(int[] stocks){
        int[] ans=new int[stocks.length];
        ans[0]=1;
        for (int i = 1; i <stocks.length ; i++) {
           int count=0;
           int j=i;
           while(stocks[j]<=stocks[i]){
               if (j==0){
                   count++ ;
                   break;
               }
               count++;
               j--;
           }
           ans[i]=count;
        }
        return ans;
    }

    //Approach-2 Using Stack approach(As it has a linear time complexity)
    private static int[] stockSpanStack(int[] stack) {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[stack.length];

        //it will store the indices
        //we'll find the nge on left
        nge[0] = 1;
        st.push(0);
        for (int i = 1; i < stack.length; i++) {
            while (!st.isEmpty() && stack[i] > stack[st.peek()]) st.pop();
            if (st.isEmpty()) nge[i]=i+1;
            else nge[i]=i-st.peek();
            st.push(i);
        }
        return nge;
    }



    public static void main(String[] args) {
        int[] stocks={100,80,60,70,60,75,85};
        //System.out.println(Arrays.toString(stockSpanIterative(stocks)));
       System.out.println(Arrays.toString(stockSpanStack(stocks)));
    }
}
