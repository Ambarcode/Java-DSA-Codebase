package com.ak.Recursion.PatternQuestions;

public class MirrorInvertedHalfPyramid {
    static void pattern(int row, int col,int t, int m,int currLine){
        if(t==0) return;
        if (col<row){
            if (col < m - currLine) {
                System.out.print(" ");

            } else {
                System.out.print("*");
            }
            pattern(row, col + 1,t,m,currLine);
        }
        else {
            System.out.println();
            pattern(row,0,t-1,m,currLine-1);
        }
    }
    public static void main(String[] args) {
              pattern(5,0,5,5,5);
    }
}
