package com.ak.Arrays.ArrayQuestion.TwoDimensionalArray;

import java.util.HashSet;
import java.util.logging.Handler;

public class CheckForDuplicateInRowAndCol {
    //we are given a 2D matrix ,we have to find whether for each row and col there is any duplicate element or not
    private static boolean checkDuplicate(int[][] matrix){
        //let's try naive approach(we'll have to use three nested loops)

        //for row check
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int k = j+1; k <matrix[0].length ; k++) {
                    if (matrix[i][j]==matrix[i][k]) return false;
                }
            }
        }

        //for column check
        for (int i = 0; i < matrix[0].length ; i++) {
            for (int j = 0; j <matrix.length-1 ; j++) {
                for (int k = j+1; k <matrix.length ; k++) {
                    if (matrix[j][i]==matrix[k][i]) return false;
                }
            }
        }
        return true;
    }

    //we can also use hashset
    private static boolean isMatrixValid(int[][] matrix){
        for (int i = 0; i <matrix.length ; i++) {
            HashSet<Integer> set=new HashSet<>();
            for (int j = 0; j < matrix[0].length; j++) {
              if (set.contains(matrix[i][j])){
                  return false;
              }
              else set.add(matrix[i][j]);
            }
        }

        for (int i = 0; i < matrix[0].length ; i++) {
            HashSet<Integer> set=new HashSet<>();
            for (int j = 0; j < matrix.length - 1; j++) {
                if (set.contains(matrix[j][i])) return true;
                else set.add(matrix[j][i]);
            }
        }
            return true;
        }


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        boolean isValid =isMatrixValid(matrix);
        System.out.println("Is matrix valid? " + isValid);
    }

}
