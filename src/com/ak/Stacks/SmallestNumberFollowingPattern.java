package com.ak.Stacks;

import java.util.Stack;

public class SmallestNumberFollowingPattern {
    //You are given a 0-indexed string pattern of length n consisting of the characters 'I' meaning increasing &'D' meaning decreasing.
    //A 0-indexed string num of length n + 1 is created using the following conditions:
    //num consists of the digits '1' to '9', where each digit is used at most once.
    //If pattern[i] == 'I', then num[i] < num[i + 1].
    //If pattern[i] == 'D', then num[i] > num[i + 1].
    //Return lexicographically the smallest possible string num that meets the conditions.

    public String smallestNumber(String pattern) {
        int num=1;
        //for d , push the number onto the stack and increase the number
        //for i , push the number on to the stack , pop all the numbers and increase the number

        Stack<Integer> st=new Stack<>();
        int smallNum=0;

        for (int i=0;i<pattern.length();i++) {
            char ch = pattern.charAt(i);

            if (ch == 'D') {
                st.push(num);
                num++;
            }
            else {
                st.push(num);
                num++;
                while (!st.isEmpty()){
                    smallNum=smallNum*10+st.pop();
                }
            }
        }
        st.push(num);
        while (!st.isEmpty()){
            smallNum=smallNum*10+st.pop();
        }

        return smallNum+"";
    }
}
