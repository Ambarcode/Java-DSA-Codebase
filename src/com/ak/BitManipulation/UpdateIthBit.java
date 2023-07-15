package com.ak.BitManipulation;

public class UpdateIthBit {
    public static int modifyBit(int n, int p, int b)
    {
        //p is the position and b is the bit
        int mask = 1 << p-1;
        //first we'll make the ith bit to zero , then we'll & it with any number
        return (n & ~mask) | (b << p-1) ;
    }

    public static void main(String[] args) {
        int n=11;
        int b=0;
        int k=2;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(modifyBit(n,k,b)));
    }

}
