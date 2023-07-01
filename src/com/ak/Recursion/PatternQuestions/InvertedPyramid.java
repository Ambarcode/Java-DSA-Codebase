package com.ak.Recursion.PatternQuestions;

public class InvertedPyramid {

    static void pattern(int r, int c,int t){
        if(t==0) return;
        if (c<r){
            System.out.print("*");
            pattern(r,c+1,t);
        }
        else {
            System.out.println();
            pattern(r,0,t-1);
        }
    }

    public static void main(String[] args) {
       // pattern(5,0);
    }
}
