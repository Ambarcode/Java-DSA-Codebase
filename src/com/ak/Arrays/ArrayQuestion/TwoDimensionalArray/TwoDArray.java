package com.ak.Arrays.ArrayQuestion.TwoDimensionalArray;

public class TwoDArray {
    //now let's work with 2-D array
    public static void main(String[] args) {
        int[][] b=new int[3][];
        b[0]=new int[5];
        b[1]=new int[6];
        b[2]=new int[7];

        //printing using loop(Row Major Order)
        for(int i = 0; i <b.length ; i++) {
            for (int j = 0; j <b[i].length ; j++) {
                System.out.println(b[i][j]+" ");
            }
        }

        //traversing using enhanced for loop
        for (int[] arr:
             b) {
            for (int elem:
                 arr) {
                System.out.println(elem);
            }

        }
    }
}
