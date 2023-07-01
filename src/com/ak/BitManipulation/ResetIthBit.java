package com.ak.BitManipulation;

public class ResetIthBit {
    public static void main(String[] args) {
        //Reset the ith bit
        //1->0
        //just do It's & with 0
        int n=13;
        int k=3;
        System.out.println(Integer.toBinaryString(n));
        int m=~(1<<k-1);
        System.out.println(Integer.toBinaryString(n& m));

    }
}
