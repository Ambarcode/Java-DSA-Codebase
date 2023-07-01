package com.ak.Recursion.ArrayRecursionQuestion;

import java.util.Arrays;

public class Salaries {
    public static double[] addTaxToSalaries(double[] salaries) {
        if (salaries == null || salaries.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty or null.");
        }

        return addTaxToSalariesRecursive(salaries, 0);
    }

    private static double[] addTaxToSalariesRecursive(double[] salaries, int index) {
        if (index == salaries.length) {
            return salaries; // Base case: reached the end of the array, return the updated salaries array
        }

        salaries[index] += salaries[index] * 0.1; // Add 10% tax to the current salary

        return addTaxToSalariesRecursive(salaries, index + 1); // Recursive call with the incremented index
    }

    public static void main(String[] args) {
        double[] salaries = {50000.0, 60000.0, 75000.0};
        double[] salariesWithTax = addTaxToSalaries(salaries);
        System.out.println("Salaries with Tax: " + Arrays.toString(salariesWithTax));
    }

}
