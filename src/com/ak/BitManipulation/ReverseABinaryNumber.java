package com.ak.BitManipulation;

public class ReverseABinaryNumber {
    //the approach us very simple
    private static int reverseABinary(int num){
        int curr=0;
        while (num>0){
            curr=(curr<<1) |(num & 1);
            num>>=1;
        }
        return curr;
    }

    public static void main(String[] args) {
        int num=23;
        System.out.println(Integer.toBinaryString(num));
        int curr=reverseABinary(num);
        System.out.println(Integer.toBinaryString(curr));
    }
}
