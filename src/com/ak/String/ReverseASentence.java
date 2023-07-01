package com.ak.String;

public class ReverseASentence {

    private static String reverseSentence(String sent){
        // Base case: if the sentence is empty or has only one word, return it as is
        if (sent == null || !sent.contains(" ")) {
            return sent;
        }

        int untilSpaceInx = sent.indexOf(" ");
        String firstWord = sent.substring(0, untilSpaceInx);
        // Recursively reverse the remaining sentence
        String reversedRemaining = reverseSentence(sent.substring(untilSpaceInx + 1));

        // Combine the reversed remaining sent with the first word
        return reversedRemaining + " " + firstWord;
    }

    //Approach 2:find the word append in starting
    private static String revSentence(String sentence){
        String temp="";
        String res="";

        for (int i = 0; i <sentence.length() ; i++) {
            while (i < sentence.length() && sentence.charAt(i) != ' '){
                temp = temp + sentence.charAt(i);
                i++;
            }
            if (!temp.isEmpty()) {
                // If we find a word, will add it at beginning of result.
                if (!res.isEmpty()) {
                    res = temp + " " + res;
                } else {
                    res = temp;
                }
                temp = "";
            }
        }
        return res;
}





    public static void main(String[] args) {
        String sentence="the sky    is blue";
        System.out.println(reverseSentence(sentence));
    }
}
