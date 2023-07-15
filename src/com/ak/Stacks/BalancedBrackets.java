package com.ak.Stacks;
import java.util.Stack;

public class BalancedBrackets {
    public static boolean isValid(String expr) {
        Stack<Character> st=new Stack<>();
        for (int i = 0; i <expr.length() ; i++) {
            char ch=expr.charAt(i);
            if (ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }
            else if (ch=='}' || ch==']' || ch==')'){
                if (st.isEmpty()) return false;
                if (st.peek()==oppChar(ch)){
                    st.pop();
                }
                else return false;
            }
        }
        return st.isEmpty();
    }

    private static char oppChar(char ch){
        if(ch==')') return '(';
        if(ch=='}') return '{';
        return '[';
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

}
