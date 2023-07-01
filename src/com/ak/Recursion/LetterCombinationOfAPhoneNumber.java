package com.ak.Recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfAPhoneNumber {
    //https://leetcode.com/problems/letter-combinations-of-a-phone-number/

    //first we'll store the corresponding letters correspond to the number(here indices) in a String array
    static String[] dialPad={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static List<String>  letterCombinations(String digits) {
        return helperForLetterCombination("",digits);
    }

    private  static void helperForLetterCombination(String s, String digits, List<String> ans) {
        if (digits.length()==0){ans.add(s);return;}

        int digit=digits.charAt(0)-'0';
        String str=dialPad[digit];
        for (int i = 0; i <str.length() ; i++) {
            helperForLetterCombination(s+str.charAt(i),digits.substring(1),ans);
        }
    }
    private  static List<String> helperForLetterCombination(String s, String digits) {
        if (digits.length()==0){
            List<String> list=new ArrayList<>();
            list.add(s);
            return list;
        }

        int digit=digits.charAt(0)-'0';
        String str=dialPad[digit];
        List<String> ans=new ArrayList<>();
        for (int i = 0; i <str.length() ; i++) {
            ans.addAll(helperForLetterCombination(s+str.charAt(i),digits.substring(1)));
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> ans=letterCombinations("23");
        System.out.println(ans);
    }

}
