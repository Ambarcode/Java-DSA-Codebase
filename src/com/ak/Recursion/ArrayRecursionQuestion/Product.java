package com.ak.Recursion.ArrayRecursionQuestion;

public class Product {
    //Write a recursive function that takes a list of numbers as an input and return product of all numbers in list
    public static int calculateProduct(int[] numbers) {
        return calculateProductHelper(numbers, 0);
    }

    private static int calculateProductHelper(int[] numbers, int index) {
        if (index == numbers.length) {
            return 1;  // Base case: end of the array, return 1
        } else {
            return numbers[index] * calculateProductHelper(numbers, index + 1);  // Recursive case
        }
    }

    public static void main(String[] args) {
        int[] myArray = {2, 3, 4, 5};
        int product = calculateProduct(myArray);
        System.out.println("Product: " + product);
    }
}
