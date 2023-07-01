package com.ak.Recursion.RecursionAssignment;

public class SumOfNaturalNumbers {

    //1st Approach (stack building time)
    static int sum(int n){
        if(n==0) return 0;
        return n+sum(n-1);
    }

    //2nd Approach (stack falling time)
    static int sum2(int n){
        if(n==0) return 0;
        int sum=sum2(n-1);
        return  n+sum;
    }
    public static void main(String[] args) {
        int s=sum2(5);
        System.out.println(s);
    }
}
