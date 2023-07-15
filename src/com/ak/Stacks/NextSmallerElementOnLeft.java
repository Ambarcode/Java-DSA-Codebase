package com.ak.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElementOnLeft {
    private static int[] nextSmallerElemLeft(int[] arr) {
        //-1 indicates there is no smaller element that exist on left
        int[] ans = new int[arr.length];
        //100,80,56,76,66,89,99,90,333
       Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        ans[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i]<=st.peek()) st.pop();

            if(st.isEmpty()) ans[i]=-1;
            else ans[i]=st.peek();
            st.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr={4, 8, 5, 2, 25};
        System.out.println(Arrays.toString(nextSmallerElemLeft(arr)));
    }
}
