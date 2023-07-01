package com.ak.Recursion.RecursionAssignment;

public class PrimeNumber {
    //we can solve it by taking a helper function
    static boolean isPrime(int n){
        if(n<=1) return false;
       return isPrimeHelper(n , 2);
    }

    private static boolean isPrimeHelper(int n, int divisor) {
        if(divisor*divisor>n) return true;
        if(n%divisor==0) return false;
        return isPrimeHelper(n,divisor+1);
    }

    public static void main(String[] args) {
        System.out.println(isPrime(99));
    }
}
