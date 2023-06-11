package com.ak.Recursion.RecursionAssignment;

public class CountZeroOccurences {

    //Taking count variable in the argument
    static void  countAllZero(int n, int count ){
           if(n<=0){ System.out.println(count);
           return;}
           if(n%10==0) count+=1;
           countAllZero(n/10,count);
    }

    //Another approach where we won't take count in the argument
    static int countAllZero(int n){
      if(n==0) return 0;
      return n%10==0?1+countAllZero(n/10):countAllZero(n/10);
    }

    //Another approach when the function is returning from the stack
    static int countAllZero2(int n) {
        if(n<=0) return 0;
        int count=countAllZero2(n/10);
        if(n%10==0) {
            return count+1;
        }else return count;

    }

    //Another Approach , by taking a helper function

    static int countAllZero3(int n){
        return  helper(n, 0);
    }

    static int helper(int n, int col){
        if(n==0) return col;
        int rem=n%10;
        if(rem==0) return helper(n/10,col+1);
        else return helper(n/10,col);
    }


    public static void main(String[] args) {

        int n=10020;
        int count= countAllZero(n);
        System.out.println(count);
    }
}
