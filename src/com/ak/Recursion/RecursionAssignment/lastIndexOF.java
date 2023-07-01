package com.ak.Recursion.RecursionAssignment;

public class lastIndexOF {
    private static boolean searchFromLast(int[] arr , int target , int index){
        if(index == -1) return false;
        if(arr[index] == target) return true;
        return searchFromLast(arr, target ,index-1);
}

    public static void main(String[] args) {
        int[] arr={22,5,4,22,-8};
        System.out.println(searchFromLast(arr,22,4));
    }
}
