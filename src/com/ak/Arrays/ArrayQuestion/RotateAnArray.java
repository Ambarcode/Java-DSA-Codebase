package com.ak.Arrays.ArrayQuestion;

import java.util.Arrays;

public class RotateAnArray {

    //method to rotate an array to the right by k steps
    public static void rotateArray(int[] nums , int rotations){
        //Similar to the Approach of reversing a number

        //rotation must be in range
        rotations=rotations% nums.length;

        //if the value of rotation is negative
        if (rotations<0){
            rotations+=nums.length;
        }

        int[] arr={10,20,30,40,50};

        //1st Part reverse
        reverse(nums,0,nums.length-rotations-1);

        //2nd Part Reverse
        reverse(nums,nums.length-rotations,nums.length-1);

        //Now reverse te complete array
        reverse(nums , 0 , nums.length-1);

    }
    //method to rotate an array to the left by k steps
    public static void rotateArray2(int[] nums , int rotations){
        //Similar to the Approach of reversing a number

        //rotation must be in range
        rotations=rotations% nums.length;

        //if the value of rotation is negative
        if (rotations<0){
            rotations+=nums.length;
        }

        int[] arr={10,20,30,40,50};

        //1st Part reverse
        reverse(nums,0,nums.length-rotations-1);

        //2nd Part Reverse
        reverse(nums,nums.length-rotations,nums.length-1);

        //Now reverse te complete array
        reverse(nums , 0 , nums.length-1);

    }



    private static void reverse(int[] arr , int i , int j){
        while (i<=j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;j--;
        }
    }

    public static void main(String[] args) {
        int[] nums={10,20,30,40,50};
        rotateArray(nums,2);
        System.out.println(Arrays.toString(nums));
    }
}
