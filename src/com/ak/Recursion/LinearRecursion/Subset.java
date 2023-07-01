package com.ak.Recursion.LinearRecursion;

public class Subset {
    private static void generateSubset(String pr , String up){
        if (up.isEmpty()){
            System.out.println(pr);
            return;
        }

        //include the character
        generateSubset(pr+up.charAt(0),up.substring(1));

        //don't include the character
        generateSubset(pr,up.substring(1));
    }

    public static void main(String[] args) {
        generateSubset("","Ambar");
    }
}
