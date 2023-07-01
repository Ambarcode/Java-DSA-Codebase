package com.ak.Recursion;

public class Reverse {

    //1st Approach
    static String rev(String str){
        if(str.length()==0) return " ";
        return str.length()<=1 ? str:str.charAt(str.length()-1)+rev(str.substring(0,str.length()-1));
    }

    //2nd Approach
    static String rev2(String str){
        return (str.length()==1)?str:rev(str.substring(1)) + str.charAt(0);
    }
    public static void main(String[] args) {
        String input = "Ambar";
        String reversed = rev2(input);
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
    }

}
