package com.ak.Recursion.PatternQuestions;

public class HollowSquarePattern {
    static void pattern(int r, int c, int t) {
        if (t == 0) return;
        if (c < r) {
            if (c == 0 || c == r - 1 || t==r || t == 1 ) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            pattern(r, c + 1, t);
        } else {
            System.out.println();
            pattern(r, 0, t - 1);
        }
    }

    public static void main(String[] args) {
        pattern(5,0,5);
    }
}
