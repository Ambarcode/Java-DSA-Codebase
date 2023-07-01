package com.ak.BitManipulation;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;

import java.io.IOException;

public class EvenOdd {
    //using bit manipulation checks whether the number is even or odd
    private static boolean evenOdd(int n){
        return (n & 1) == 0;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(evenOdd(-58));
    }
}
