package com.ak.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementOnRight {
    private static int[] nextGreaterElemRight(int[] arr) {
        //-1 indicates there is no greater element that exist on right
        int[] ans = new int[arr.length];
        //100,80,56,76,66,89,99,90,333
        java.util.Stack<Integer> st = new Stack<>();
        st.push(arr[arr.length-1]);
        ans[ans.length-1] = -1;
        for (int i = arr.length-2; i >=0; i--) {
            while (!st.isEmpty() && arr[i]>=st.peek()) st.pop();

            if(st.isEmpty()) ans[i]=-1;
            else ans[i]=st.peek();
            st.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr= { 4 , 5 , 2 , 25 };
        System.out.println(Arrays.toString(nextGreaterElemRight(arr)));
    }
}
