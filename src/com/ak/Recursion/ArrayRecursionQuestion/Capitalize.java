package com.ak.Recursion.ArrayRecursionQuestion;

import java.util.Arrays;

public class Capitalize {

    public static String[] capitalizeWords(String[] words) {
        return capitalizeWordsHelper(words, 0, new String[words.length]);
    }

    private static String[] capitalizeWordsHelper(String[] words, int index, String[] capitalizedArray) {
        if (index == words.length) {
            return capitalizedArray;  // Base case: reached the end of the array, return the capitalized array
        } else {
            capitalizedArray[index] = words[index].toUpperCase();  // Capitalize the current word and store it in the capitalized array
            return capitalizeWordsHelper(words, index + 1, capitalizedArray);  // Recursive call with the incremented index
        }
    }


    public static String[] capitalizeWords2(String[] words) {
        return capitalizeWordsHelper(words, 0);
    }

    private static String[] capitalizeWordsHelper(String[] words, int index) {
        if (index == words.length) {
            return new String[0];  // Base case: end of the array, return an empty array
        } else {
            String capitalizedWord = words[index].toUpperCase();  // Capitalize the word
            String[] remainingWords = capitalizeWordsHelper(words, index + 1);  // Recursive call for the remaining words
            String[] result = new String[remainingWords.length + 1];  // Create a new array to hold the capitalized word and the remaining words
            result[0] = capitalizedWord;  // Store the capitalized word at the beginning of the result array
            System.arraycopy(remainingWords, 0, result, 1, remainingWords.length);  // Copy the remaining words to the result array
            return result;
        }
    }


    public static void main(String[] args) {
            String[] myArray = {"foo", "bar", "world"};
            String[] capitalizedArray = capitalizeWords(myArray);
            System.out.println("Capitalized Array: " + Arrays.toString(capitalizedArray));
        }
    }

