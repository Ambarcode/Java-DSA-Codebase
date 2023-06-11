package com.ak.Recursion.RecursionAssignment;

public class CountAllOccurrence {
    private static int countOccurrence(int[] arr , int target , int index){
        if(index == arr.length) return 0;
        return (arr[index] == target ? 1 : 0) + countOccurrence(arr, target, index+1);
}

    public static void main(String[] args) {
        int[] arr={2,3,2,4,5,2,5,2};
        System.out.println(countOccurrence(arr,2,0));
    }
}
