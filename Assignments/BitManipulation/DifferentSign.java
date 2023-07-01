package com.ak.BitManipulation;

public class DifferentSign {
    //using bit manipulation , we have to check whether two numbers are of different sign
    //The sign bit is 1 in negative number , whereas , 0 for positive number , Xor of the two numbers will make sign mit 0 if b
    private static boolean ifOppositeSigns(int x, int y){
        return ((x ^ y) < 0);
    }

    public static void main(String[] args) {
        if(ifOppositeSigns(10,-1)){
            System.out.println("Opposite Signs");
        }
        else{
            System.out.println("Same Sign");
        }
    }
}
