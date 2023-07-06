package com.ak.Arrays.ArrayQuestion.TwoDimensionalArray;

public class PrintMatrixINSnakePattern {
//the only catch is if row is even , print from left to right else right to left

public static void main(String[] args) {
    int[][] result={
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {10,11,12}
    };
    for (int i = 0; i <result.length; i++) {
        //left to right traversal
        if(i%2==0){
            for (int j = 0; j <result[0].length ; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
        else {
            for (int j = result[0].length-1; j >=0 ; j--) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}
}
