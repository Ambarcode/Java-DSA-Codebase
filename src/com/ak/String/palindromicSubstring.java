package com.ak.String;

public class palindromicSubstring {
    //given a string generate all the palindromic  substring
    //first we need to understand how to generate all palindrome for a given string


    private static void generatePalindromicSubstring(String str) {
        for (int i = 0; i < str.length(); i++) {
            String substr = "";
            for (int j = i; j < str.length(); j++) {
                substr += str.charAt(j);
                if (isPalindrome1(substr)) {
                    System.out.println(substr);
                }
            }
        }
    }

    private static boolean isPalindrome1(String str) {
        String newStr = str.toLowerCase();
        int left = 0;
        int right = str.length() - 1;

        while (left <= right) {
            if (newStr.charAt(left) != newStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abccbc";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String temp = str.substring(i, j);
                if (isPalindrome(temp)) {
                    System.out.println(temp);
                }
            }
        }


//    public static void main(String[] args) {
//        generatePalindromicSubstring("malayalam");
//    }
    }
}
