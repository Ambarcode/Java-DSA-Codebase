package com.ak.BitManipulation;

public class FindTheIthBit {
    private static int findIthBit(int n , int k){
        //for finding the ith bit , we'll lft shift 1 to k-1 times and & it with original number
        return (n&(1<<(k-1)));
    }

    public static void main(String[] args) {
        int n=10;
        int k=2;
        System.out.println(Integer.toBinaryString(n));
        if(findIthBit(n,k)!=0) System.out.println(1);
        else System.out.println(0);
    }
}
