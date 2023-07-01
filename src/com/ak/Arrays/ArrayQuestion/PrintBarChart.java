package com.ak.Arrays.ArrayQuestion;

public class PrintBarChart {

    private static void printBar(int[] arr){
        //first find the max bar length
        int max=Integer.MIN_VALUE;
        for(int elem: arr){
            max=Math.max(elem , max);
        }
        for (int i=9;i>=1;i--){
            for (int k : arr) {
                if (i <= k) {
                    System.out.print("*\t");
                } else {
                    System.out.print(" \t");
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[] bar ={2,1,7,9,0};
        printBar(bar);
    }
}
