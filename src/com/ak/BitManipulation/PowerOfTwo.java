package com.ak.BitManipulation;

public class PowerOfTwo {

    // to check whether a number is power of 2 , just do its Anding with its negation  , if it turns out to be 0 , it is a negative number
    public static void main(String[] args) {

        int n=16;
        System.out.println(isPowerOfTwo(n));
    }
    private static boolean isPowerOfTwo(int n){
        return ((n & (-n))==0);
    }
}
