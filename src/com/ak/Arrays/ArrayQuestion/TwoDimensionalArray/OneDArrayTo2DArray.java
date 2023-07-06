package com.ak.Arrays.ArrayQuestion.TwoDimensionalArray;

public class OneDArrayTo2DArray {
    private static int[][] convert(int[] arr, int row , int col){
        int[][] matrix=new int[row][col];
        int x=0;
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                matrix[i][j]=arr[x++];
            }
        }
        return matrix;
    }

    //The approach used above is not quiet efficient
    // we can easily do so with a single for loop
    //Time Complexity: O(n)
    private static int[][] convertTo2D(int[] arr , int n , int m){

        if(m*n!= arr.length) return new int[0][0];
        int[][] matrix=new int[n][m];
        int col=0;
        int row=0;
        for (int j : arr) {
            matrix[row][col++] = j;
            if (col == m) {
                col = 0;
                row += 1;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        int[][] result=convertTo2D(arr,3,3);
        for(int[] arr1: result){
            for(int elem: arr1){
                System.out.print(elem);
            }
            System.out.println();
        }
    }
}
