package com.ak.Recursion.ArrayRecursionQuestion;

public class Highest {
    public static int findHighestElement(int[] array) {
        return findHighestElementRecursive(array, array.length - 1);
    }

    private static int findHighestElementRecursive(int[] array, int index) {
        if (index == 0) {
            return array[0]; // Base case: only one element in the array
        }

        int current = array[index];
        int previousHighest = findHighestElementRecursive(array, index - 1);

        return Math.max(current, previousHighest);
    }
    public static int findHighestElement2(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty or null.");
        }

        return findHighestElementTailRecursive(array, array[0], 1);
    }

    private static int findHighestElementTailRecursive(int[] array, int highest, int index) {
        if (index == array.length) {
            return highest;  // Base case: reached the end of the array, return the highest element
        }

        int current = array[index];
        highest = Math.max(highest, current);  // Update the highest element if necessary

        return findHighestElementTailRecursive(array, highest, index + 1);  // Tail recursive call
    }

    public static void main(String[] args) {
        int[] myArray = {5, 8, 2, 9, 1, 11, 4};
        int highestElement = findHighestElement(myArray);
        System.out.println("Highest Element: " + highestElement);
    }
}
