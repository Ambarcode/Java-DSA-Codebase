package com.ak.Recursion.ArrayRecursionQuestion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        int totalParenthesis=2*n;
        //I have two choices for each spot , either to include the left and right parenthesis and check whether we can put the parenthesis over there or not
        List<String> result=new ArrayList<>();
        generateParenthesisHelper(result , n , 0 , 0 , "");
        return result;

    }
    private static void generateParenthesisHelper(List<String> result , int n, int opening ,int closing , String output){

        if(output.length()==2*n) {result.add(output); return;}

        //we can maximum put three opening brackets
        if(opening<n){
            generateParenthesisHelper(result, n , opening+1, closing , output+"(");
        }
        //at least one opening bracket should be there to put a closing bracket
        if(closing<opening){
            generateParenthesisHelper(result, n, opening, closing+1, output+")");
        }
    }

    public static List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper2(result, n, 0, 0, new StringBuilder());
        return result;
    }

    private static void generateParenthesisHelper2(List<String> result, int n, int opening, int closing, StringBuilder output) {
        if (output.length() == 2 * n) {
            result.add(output.toString());
            return;
        }
        if(output.length()>2*n) return;

        if (opening < n) {
            output.append("(");
            generateParenthesisHelper2(result, n, opening + 1, closing, output);
            //output.deleteCharAt(output.length() - 1);
        }

        if (closing < opening) {
            output.append(")");
            generateParenthesisHelper2(result, n, opening, closing + 1, output);
           // output.deleteCharAt(output.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> ans=generateParenthesis2(3);
        System.out.println(ans);
    }
}
