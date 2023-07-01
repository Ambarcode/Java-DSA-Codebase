package com.ak.Arrays.BinarySearch;

public class SearchElement {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11, 13};
        int target = 7;
        int index = binarySearch(array, target);

        if (index != -1) {
            System.out.println("Target element found at index: " + index);
        } else {
            System.out.println("Target element not found in the array.");
        }
    }
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; // Target element found, return the index
            } else if (array[mid] < target) {
                left = mid + 1; // Target element is in the right half
            } else {
                right = mid - 1; // Target element is in the left half
            }
        }

        return -1; // Target element not found in the array
    }
}
