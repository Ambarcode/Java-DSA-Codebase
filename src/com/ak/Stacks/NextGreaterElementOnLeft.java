package com.ak.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementOnLeft {

    //we'll solve it using the same approach that is for each element we'll pop the element from the stack until the element at the top is greater
    private static int[] nextGreaterElemLeft(int[] arr) {
        //-1 indicates there is no greater element that exist on left
        int[] ans = new int[arr.length];
        //100,80,56,76,66,89,99,90,333
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        ans[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i]>=st.peek()) st.pop();

            if(st.isEmpty()) ans[i]=-1;
            else ans[i]=st.peek();
            st.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nge={1,2,3,4,1,2,3,4};
        System.out.println(Arrays.toString(nextGreaterElemLeft(nge)));
    }
}
