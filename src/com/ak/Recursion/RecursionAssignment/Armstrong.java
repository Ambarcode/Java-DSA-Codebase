package com.ak.Recursion.RecursionAssignment;

public class Armstrong {

    public static boolean isArmstrong(double n){
        int digit=(int)(Math.log10(n))+1;
        return n==helper((int) n,digit);
    }

    private static double helper(int n,int digit){
        if(n==0) return 0;
        return Math.pow(n%10,digit)+helper(n/10,digit);
    }

    public static void main(String[] args) {
        System.out.println(isArmstrong(9474));
    }
}
