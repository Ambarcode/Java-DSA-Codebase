package com.ak.Recursion.RecursionAssignment;

public class Series {

    //1st Approach (Stack Building Time)
    static double series(int n){
        if(n==0) return 0;
        return Math.pow(n,n)/n + series(n-1);
    }

    //2nd Approach (Stack fallen time)

    static double series2(int n){
        if (n==0) return 0;
        double ans=series2(n-1);
        return Math.pow(n,n)/n+ans;
    }
    public static void main(String[] args) {
        System.out.println(series2(2));
    }
}
