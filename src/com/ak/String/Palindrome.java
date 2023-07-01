package com.ak.String;

public class Palindrome {
    //Approach -1 Using Two pointer Approach
    private static boolean isPalindrome(String  str){
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

    //Approach 2 : Using StringBuilder
    private static boolean isPalindrome2(String str){
        StringBuilder sb=new StringBuilder(str);
        sb.reverse();
        return str.equals(sb.toString());
    }



    public static void main(String[] args) {
        System.out.println(isPalindrome("nitiN"));
    }

}
