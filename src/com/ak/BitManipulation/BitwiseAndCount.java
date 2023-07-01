package com.ak.BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class BitwiseAndCount {
//    Given a non-negative integer n, find the number of integers x such that 0 <= x <= n and n & x == x
//    Input: n = 5
//    Output: 4
//    Explanation: The integers x that satisfy the condition are 0, 1, 4, and 5.

    private static int  countSameNumberDoingAnd(int n){
        int count=0;
        for (int i=n;i>=0;i--){
            if ((n&i)==i) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSameNumberDoingAnd(5));
    }
}
