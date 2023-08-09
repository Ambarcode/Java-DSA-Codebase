package com.ak.String;

import java.util.Arrays;

public class RunningLengthEncoding {
    public static void main(String[] args) {
       String str="aaaabbbccccddde";
       char[] ch=str.toCharArray();
        Arrays.sort(ch);
        str= Arrays.toString(ch);
       int count=1;

        for (int i = 0; i <str.length()-1 ; i++) {
            if (str.charAt(i)==str.charAt(i+1)) {
                count++;
                continue;
            }
            System.out.print(str.charAt(i)+""+count);
            count=1;

        }
        System.out.println(str.charAt(str.length()-1)+""+count);

    }
}

class Solution {
    public int compress(char[] chars) {
        int index = 0;  // Index to track the current position in the modified chars array
        int count = 1;  // Count of consecutive characters
        int n = chars.length;  // Length of the original chars array

        for (int i = 0; i < n - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                count++;
            } else {
                chars[index++] = chars[i];  // Store the character at the current position
                if (count > 1) {
                    String countStr = String.valueOf(count);
                    for (char c : countStr.toCharArray()) {
                        chars[index++] = c;  // Store each digit of the count as a separate character
                    }
                }
                count = 1;  // Reset the count for the next character
            }
        }

        // Store the last character and its count
        chars[index++] = chars[n - 1];
        if (count > 1) {
            String countStr = String.valueOf(count);
            for (char c : countStr.toCharArray()) {
                chars[index++] = c;
            }
        }

        return index;  // Return the length of the modified chars array
    }
}

