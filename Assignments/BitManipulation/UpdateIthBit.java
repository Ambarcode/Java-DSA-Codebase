package com.ak.BitManipulation;

public class UpdateIthBit {
    public static int modifyBit(int n, int p, int b)
    {
        int mask = 1 << p-1;
        //first we'll make the ith bit to zero , then we;ll and it with any number
        return (n & ~mask) | ((b << p-1) & mask);
    }

    public static void main(String[] args) {
        int n=5;
        int b=0;
        int k=1;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(modifyBit(n,k,b)));
    }

}
