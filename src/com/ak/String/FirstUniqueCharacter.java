package com.ak.String;

import java.util.HashMap;

public class FirstUniqueCharacter {
    //given a string we have to find the first unique character

    private static char firstUnique(String str){
        HashMap<Character,Integer> map =new HashMap<>();

        for(char ch: str.toCharArray()){
            map.put(ch, map.getOrDefault(ch , 0)+1);
        }

        for (int i = 0; i <str.length() ; i++) {
            if(map.get(str.charAt(i))==1) return str.charAt(i);
        }

        //no unique character found
        return 0;
    }

    public static void main(String[] args) {
        String str="aaabbsjjk";
        System.out.println(firstUnique(str));
    }
}
