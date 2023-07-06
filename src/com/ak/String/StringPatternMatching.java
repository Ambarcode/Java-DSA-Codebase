package com.ak.String;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringPatternMatching {
     //Approach 1: Naive Approach: We'll start an i pointer and a j pointer
    //for each i we'll check whether the corresponding char at k is equal or not , if yes we'll move both i and j pointer ,else we;ll make j again 0 and make i++
    private static int[] stringPatternMatchingNaive(String string , String pattern){
        int n=pattern.length();
        int start=0;
        int end=0;
        int j=0;
        int k=0;
        for (int i = 0; i <=string.length()-n ; i++) {
            start=i;
            k=i;
                  while (j<n){
                if (string.charAt(k)==pattern.charAt(j)){
                    j++;
                    k++;
                }
                else {
                    j=0;
                    break;
                }
            }
                  if(j==n){
                      return new int[]{start,k-1};
                  }
        }
        //if no pattern found return -1;
        return new int[]{-1,-1};
    }

    //Approach-2 Using KMP Algorithm
    // As you can see the above approach is not good
    //lets consider an example
    //String str="aaaafaaaam"
    //String pattern="aaaab"
    //As you can see , it has a time complexity of O(m*n)

    //Key Point: we have to look for the longest prefix that is also a suffix

    public static int[] stringPatternMatchingUsingKMP(String text, String pattern) {
        int[] lps = computeLPS(pattern);
        int i = 0;
        int j = 0;

        while (i < text.length() && j < pattern.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        if (j == pattern.length()) {
            return new int[]{i - j,i-1};
        }

        return new int[]{-1,-1};
    }

    public static int[] computeLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int j = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
    //Approach 3: Robin Karp Method
    private static int[] StringPatternMatchingUsingRobinKarp(String text, String pattern) {
        //first we need a hashfunction , which will generate the hash value for our pattern
        //then using sliding window approach we'll iterate through our pattern and find the similar hash value and if it is same we'll match the corresponding char
        int textLen = text.length();
        int patternLen = pattern.length();

        int patternHash = calculateHash(pattern);
        int textHash = calculateHash(text.substring(0, patternLen));

        for (int i = 0; i <= textLen - patternLen; i++) {
            if (patternHash == textHash && checkEqual(text, i, i + patternLen - 1, pattern)) {
                return new int[]{i,i+patternLen-1};
            }

            if (i < textLen - patternLen) {
                textHash = rehash(text, i, i + patternLen, textHash, patternLen);
            }
        }
        return new int[]{-1,-1};

    }


    private static int calculateHash(String str) {
        int hashValue = 0;
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            hashValue += str.charAt(i);
        }
        return hashValue;
    }
    // Function to recalculate the hash value for the next window in the text
    private static int rehash(String text, int oldIndex, int newIndex, int oldHash, int patternLen) {
        int oldCharHash = text.charAt(oldIndex);
        int newCharHash = text.charAt(newIndex);
        return oldHash - oldCharHash + newCharHash;
    }

    // Function to check if two substrings are equal
    private static boolean checkEqual(String text, int start1, int end1, String pattern) {
        String substring = text.substring(start1, end1 + 1);
        return substring.equals(pattern);
    }


    public static void main(String[] args) {
        String string="AABAACAADAABAABA";
        String pattern="DAAB";
        System.out.println(Arrays.toString(stringPatternMatchingUsingKMP(string,pattern)));
    }
}
