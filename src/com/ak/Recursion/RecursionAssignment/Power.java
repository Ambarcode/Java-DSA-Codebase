package com.ak.Recursion.RecursionAssignment;

public class Power {
    //1st Approach(tail recursion)

    static int pow(int n,int p){
        if(p==1) return n;
        return n*pow(n,p-1);
    }

    public static void main(String[] args) {
        System.out.println(pow2(5,3));
    }

    //2nd Approach(Non-tail recursion)
    static int pow2(int n,int p){
        if(p==1) return n;
        return pow2(n,p-1)*n; //stack fall
    }

}


