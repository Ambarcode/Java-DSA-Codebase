package com.ak.String;

public class palindromicSubstring {
    //given a string generate all the palindromic  substring
    //first we need to understand how to generate all palindrome for a given string


    private static void generatePalindromicSubstring(String str){
        for (int i = 0; i < str.length(); i++) {
            String substr="";
            for (int j = i; j <str.length() ; j++) {
                substr+=str.charAt(j);
                if (isPalindrome(substr)){
                    System.out.println(substr);
                }
            }
        }
    }

    private static boolean isPalindrome(String str) {
        String newStr=str.toLowerCase();
        int left=0;
        int right=str.length()-1;

        while (left<=right){
            if (newStr.charAt(left)!=newStr.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        generatePalindromicSubstring("malayalam");
    }
}
