package com.ak.String;

public class MaximizeTheConfusionOfExam {
    public static int maxConsecutiveAnswers(String answerKey, int k) {
         //the approach we'll follow is to count the maximum confusion if we replace F with T and the same if for T with F, and take maxi,um out of both
        return Math.max(solve(answerKey,k,'T'),solve(answerKey,k,'F'));

    }
    public static int solve(String str, int k , char ch){
        int startP=0;
        int endP=0;
        int ans=0; //the answer will be the maximum size of valid window
        while (endP<str.length()){
            char currChar=str.charAt(endP);
            if (currChar!=ch) k--;
                while (startP<str.length() && k<0){
                    if (str.charAt(startP)==ch) {
                         startP++;
                    }else {
                        k++;
                        startP++;
                }
                    ans=Math.max(ans,endP-startP+1);
                    endP++;
            }
        }
        return ans;
    }
}
