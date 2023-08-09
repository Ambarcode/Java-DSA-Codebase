package com.ak.Arrays.ArrayQuestion.TwoDimensionalArray;

import java.util.Arrays;

public class SearchIn2DMatrix {
    //I'll solve it using binary search
    //As the matrix is strictly sorted such that element at last of each row is less than first element of next row
    private static int[] search(int[][] matrix, int target){
        if (matrix[0].length == 0){
            return new int[] {-1,-1};
        }
        if ( matrix.length == 1) {
            return binarySearch(matrix,0,  matrix[0].length, 0, target);
        }
        int rowStart=0;
        int rowEnd=matrix.length-1;
        int col=matrix[0].length/2;
        while (rowEnd>rowStart+1){
            int rowMid=rowStart+(rowEnd-rowStart)/2;
            if (matrix[rowMid][col]==target) return new int[]{rowMid,col};
            else if (matrix[rowMid][col]>target) rowEnd=rowMid;
            else rowStart=rowMid;
        }

        //now only two rows are remaining , if no element are found
        //checking for two elements of mid-col
        if (matrix[rowStart][col]==target) return new int[]{rowStart,col};
        if (matrix[rowStart+1][col]==target) return new int[]{rowStart+1,col};
        //we have to make four recursive calls

        //1st recursive call for first row
        if(target<=matrix[rowStart][col-1] ) return binarySearch(matrix,0,col-1,rowStart,target);

        //2nd recursive call for 1st row
        if (target>=matrix[rowStart][col+1] && target<=matrix[rowStart][matrix[0].length-1])return binarySearch(matrix,col+1, matrix[0].length-1,rowStart,target);

        //1st recursive call for 2nd row
        if (target<=matrix[rowStart+1][col-1])return binarySearch(matrix,0, col-1,rowStart+1,target);

        //2nd recursive call for 2nd col
       return binarySearch(matrix,col+1, matrix[0].length-1,rowStart+1,target);

    }

    private static int[] binarySearch(int[][] matrix , int colStart, int colEnd , int row , int target){
        while (colStart<=colEnd){
            int colMid=colStart+(colEnd-colStart)/2;
            if (matrix[row][colMid]==target) return new int[]{row,colMid};
            else if (matrix[row][colMid]>target) colEnd=colMid-1;
            else colStart=colMid+1;
        }
        return new int[]{-1,-1};
    }



    //now look at some easy code
    private static boolean search2(int[][] nums,int target){
        if (nums.length==0) return false;
        int n= nums.length; int m=nums[0].length;
        int low=0;
        int high=(m*n)-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if (nums[mid/m][mid%m]==target) return true;
            if (nums[mid/m][mid%m]<target) low=mid+1;  //Note: mid/m--> gives row number , mid%m==column number
            else high=mid-1;
        }
        return false;
    }

    public static void main(String[] args) {

            int[][] arr = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };
            System.out.println(Arrays.toString(search(arr, 9)));
    }
}
