package com.ak.String;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    //Two Strings are anagram if the occurrence of each character is same in both the strings and they are of equal length
    //Approach 1 : using Hashmap
    private static boolean isAnagram(String str1 , String str2){
        if (str1.length()!=str2.length()) return false;

        Map<Character,Integer> map=new HashMap<>();
        for(char ch:str1.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        // Decrement frequency for characters in str2
        for (char c : str2.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        for (int key: map.values()){
            if (key!=0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("ambar","rabma"));
    }

}
