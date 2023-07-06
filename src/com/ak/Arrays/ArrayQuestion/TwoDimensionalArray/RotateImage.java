package com.ak.Arrays.ArrayQuestion.TwoDimensionalArray;

public class RotateImage {
  //The approach is to find the transpose of a matrix and find the reverse of each row
    private static void rotate(int[][] matrix){
        TransposeOfAMatrix.transpose2(matrix);
        reverseEachRow(matrix);
    }

    private static void reverseEachRow(int[][] nums){
        for (int i = 0; i <nums.length ; i++) {
            for (int j = 0; j <nums.length/2 ; j++) {
                int temp=nums[i][j];
                nums[i][j]=nums[i][nums.length-j-1];
                nums[i][nums.length-j-1]=temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate(arr);
        for(int[] arr1: arr){
            for(int elem: arr1){
                System.out.print(elem);
            }
            System.out.println();
        }
    }
}
