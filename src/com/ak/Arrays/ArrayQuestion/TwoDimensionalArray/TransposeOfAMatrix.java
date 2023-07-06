package com.ak.Arrays.ArrayQuestion.TwoDimensionalArray;

public class TransposeOfAMatrix {
    public static int[][] transpose(int[][] matrix) {
        //we have to convert row to col and col to row
        int row=matrix.length;
        int col=matrix[0].length;
        int[][] arr =new int[col][row];
        for(int i=0;i<col;i++)
        {
            for(int j=i+1;j<row;j++)
            {
                arr[i][j]=matrix[j][i];
            }
        }
        return arr;
    }


    //we can also solve in  O(1) space
    //Hint: Just Modify the original array
    static void transpose2(int[][] matrix){
        int row=matrix.length;
        int col=matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = i+1; j <col ; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] result={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        for(int[] arr1: result){
            for(int elem: arr1){
                System.out.print(elem);
            }
            System.out.println();
        }
    }
}
