package com.ak.Arrays.ArrayQuestion.TwoDimensionalArray;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumberInAMatrix {
  //  A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
        public List<Integer> luckyNumbers (int[][] matrix) {
            //now how to solve this question
            //the approach is simple , we;ll take two variables min and max , for each iteration , I'll calculate the maximum element of the ith row and max element of the ith column , and after that we'll check whether they are equal or not , if they are equal we'll return that ssparticular element

            ArrayList<Integer> min=new ArrayList<Integer>();
            ArrayList<Integer> max=new ArrayList<Integer>();

            for (int[] value : matrix) {
                int minimum = Integer.MAX_VALUE;
                for (int i : value) {
                    minimum = Math.min(i, minimum);
                }
                min.add(minimum);
            }
            for(int j=0;j<matrix[0].length;j++){
                int maximum=Integer.MIN_VALUE;
                for (int[] ints : matrix) {
                    maximum = Math.max(ints[j], maximum);
                }
                max.add(maximum);
            }

            max.retainAll(min);
            return max;
        }
    }

