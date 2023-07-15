package com.ak.Stacks;

import java.util.Stack;

public class LargestAreaOFHistogram {
//    Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
//    return the area of the largest rectangle in the histogram.

    //Approach 1 : Iterative Approach
    public static int largestRectangleArea(int[] arr){
        // so what we have to do : For each pillar I have to find the next smaller pillar on right and left
        int max=Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            int left=i;
            int right=i;

            //finding the smaller pillar on left
            while (left>0 && arr[left-1]>=arr[i]){
                left--;
            }

            //finding the smaller right pillar
            while (right<arr.length-1 && arr[right+1]>=arr[i]){
                right++;
            }

            int width=right-left+1;
            int area=arr[i]*width;
            max=Math.max(max,area);
        }
        return max;
    }


    //Approach 2: Efficient Approach Using Stack
    private static int largestArea(int[] heights){
        int maxArea=Integer.MIN_VALUE;
        Stack<Integer> st1=new Stack<>();
        int[] nseL=new int[heights.length];

        st1.push(0);
        nseL[0]=-1; //most important , if we didn't find any left boundary it simply points to -1
        for (int i = 1; i < heights.length; i++) {
            while (!st1.isEmpty() && heights[i]<=heights[st1.peek()]) st1.pop();

            if (st1.isEmpty()) nseL[i]=-1;
            else nseL[i]=st1.peek();
            st1.push(i);
        }

        Stack<Integer> st2=new Stack<>();
        int[] nseR=new int[heights.length];

        st2.push(heights.length-1);
        nseL[heights.length-1]=heights.length; //most important , if we didn't find any left boundary it simply points to -1
        for (int i = heights.length-2; i >=0; i--) {
            while (!st2.isEmpty() && heights[i]<=heights[st2.peek()]) st2.pop();

            if (st2.isEmpty()) nseR[i]=heights.length;
            else nseR[i]=st2.peek();
            st2.push(i);
        }

        for (int i = 0; i <heights.length ; i++) {
            int width=nseR[i]-nseL[i]-1;
            int area=width*heights[i];
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;

    }

    public static void main(String[] args) {
        int[] heights={2,1,5,6,2,3};
        //System.out.println(largestRectangleArea(heights));
       System.out.println(largestArea(heights));
    }
}
