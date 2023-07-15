package com.ak.Arrays.ArrayQuestion;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FindMissingAndDuplicate {
//Given an unsorted array of size n. Array elements are in the range of 1 to n.
// One number from set {1, 2, …n} is missing and one number occurs twice in the array. Find these two numbers.
//Examples:
//Input: arr[] = {3, 1, 3}
//Output: Missing = 2, Repeating = 3
//Explanation: In the array, 2 is missing and 3 occurs twice
//Input: arr[] = {4, 3, 6, 2, 1, 1}
//Output: Missing = 5, Repeating = 1

    //Approach 1 : Using Set
    private static int[] findMissingAndDuplicate(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        int duplicate = 0;
        int missing = 0;
        //we'll treat the element as index , we'll mark the visited index as true , if it repeats it's the repeated number
        for (int elem: arr) {
            if (map.get(elem)==null) map.put(elem , true);
            else {
                duplicate=elem;
                break;
            }
        }

        //for missing number check
        for (int i = 1; i <= arr.length; i++) {
            if (map.get(i) == null) {
                missing = i;
            }
        }
        return new int[]{missing, duplicate};
    }

    public static void main(String[] args) {
        int[] arr={4, 3, 6, 2, 1, 1 };
        System.out.println(Arrays.toString(findMissingAndDuplicate(arr)));
    }
}
