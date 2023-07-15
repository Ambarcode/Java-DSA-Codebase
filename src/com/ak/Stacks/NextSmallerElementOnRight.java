package com.ak.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElementOnRight {
    private static int[] nextSmallerElemRight(int[] arr) {
        //-1 indicates there is no smaller element that exist on right
        int[] ans = new int[arr.length];
        //100,80,56,76,66,89,99,90,333
        java.util.Stack<Integer> st = new Stack<>();
        st.push(arr[arr.length-1]);
        ans[arr.length-1] = -1;
        for (int i = arr.length-2; i >=0; i--) {
            while (!st.isEmpty() && arr[i]<=st.peek()) st.pop();

            if(st.isEmpty()) ans[i]=-1;
            else ans[i]=st.peek();
            st.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr={13, 7, 6, 12};
        System.out.println(Arrays.toString(nextSmallerElemRight(arr)));
    }
}
