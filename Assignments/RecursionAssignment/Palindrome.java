package com.ak.Recursion.RecursionAssignment;

public class Palindrome {
    static boolean isPalindrome(String str){
        return str.equals(helper(str));
    }

    private static String helper(String str) {
        if(str.equals("")) return str;
        return str.charAt(str.length()-1)+helper(str.substring(0,str.length()-1));
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("ambar"));
    }
}
