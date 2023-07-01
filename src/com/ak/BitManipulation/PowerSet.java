package com.ak.BitManipulation;

import java.util.ArrayList;
import java.util.Collections;

public class PowerSet {
    static ArrayList<String> AllPossibleStrings(String s) {
        int n = s.length();
        ArrayList<String>ans=new ArrayList<>();
        for (int num = 0; num < (1 << n); num++) {
            String sub = "";
            for (int i = 0; i < n; i++) {
                //check if the ith bit is set or not
                if ((num & (1 << i))!=0) {
                    sub += s.charAt(i);
                }
            }
            if (sub.length() > 0) {
                ans.add(sub);
            }
        }
        Collections.sort(ans);
        return ans;
    }
    public static void main(String args[])
    {


        String s="abc";
        ArrayList<String> ans = AllPossibleStrings(s);
        //print all the subsequence.
        System.out.println("All possible subsequences are ");
        for (String it : ans) {
            System.out.print( it+" ");
        }

    }
}
