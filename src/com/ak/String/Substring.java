package com.ak.String;

import java.util.ArrayList;
import java.util.List;

public class Substring {
    public static List<String> generateSubstring(String str) {
        List<String> substrings = new ArrayList<>();

        int length = str.length();

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                substrings.add(str.substring(i, j));
            }
        }

        return substrings;
    }
    private static void generateAllSubstrings(String str){
        for (int i = 0; i < str.length(); i++) {
            String substr="";
            for (int j = i; j <str.length() ; j++) {
                substr+=str.charAt(j);
                System.out.println(substr);
            }
        }
    }

    public static void main(String[] args) {
        String input = "Pratham";
        generateAllSubstrings(input);
    }
}

class SubstringGenerator {
    public static void generateSubstrings(String str) {
        generateSubstringsHelper(str, 0, "");
    }

    private static void generateSubstringsHelper(String str, int index, String substring) {
        if (index == str.length()) {
            System.out.println(substring);
            return;
        }

        generateSubstringsHelper(str, index + 1, substring + str.charAt(index));
        generateSubstringsHelper(str, index + 1, substring);
    }

    public static void main(String[] args) {
        String str = "abc";
        generateSubstrings(str);
    }
}

