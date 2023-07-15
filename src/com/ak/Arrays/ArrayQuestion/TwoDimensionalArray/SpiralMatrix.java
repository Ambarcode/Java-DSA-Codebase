package com.ak.Arrays.ArrayQuestion.TwoDimensionalArray;

import java.util.ArrayList;
import java.util.List;

 public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        //so we have to make four checks
        //Basically four boundaries along which we'll be traversing
        //from top  left to top right , from  right top to  right bottom , from bottom left to bottom  right , from left bottom to left top
        int m=matrix.length;
        int n=matrix[0].length;
        int left=0;
        int right=matrix[0].length-1;
        int top=0;
        int bottom =matrix.length-1;
        List<Integer> list=new ArrayList<>();
        while(top<=bottom && left<=right){

            //for top left to top right traversal

            for(int i=left;i<=right;i++)
                list.add(matrix[top][i]);
            top++;

            //now move from right top to right bottom

            for(int i=top;i<=bottom ;i++)
                list.add(matrix[i][right]);

            right--;

            //now move from bottom left to bottom right
            if(top<=bottom){
                for(int i=right;i>=left ;i--)
                    list.add(matrix[bottom][i]);

                bottom--;
            }

            //now moving from bottom left to top left
            if(left<=right){
                for(int i=bottom;i>=top;i--)
                    list.add(matrix[i][left]);

                left++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][]  matrix={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        List<Integer> ans;
        ans = spiralOrder(matrix);
        System.out.println(ans);
    }
}

