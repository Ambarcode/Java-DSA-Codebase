package com.ak.Tries;

import java.util.HashSet;
import java.util.Set;

public class CountDistinctSubstring {

    //Approach 1:Count number of Substring , store it in hashset , return the size of hashset
    //Time Complexity: O(N^2) in case of ordered set and N^2 logn in case of Unordered set
    //Space Complexity : now let's suppose the case where all the subsets generated are distinct
    //In that case length of minimum substring is 1 and length of maximum one is n , So on an average n/2 length
    //for n^2 calls , we have n^2 distinct substrings(assumption) , S0 WE HAVE N^2 SUBSTRINGS WHICH NEARLY EACH SUBSTRING TAKES N^3 space

    private static int countDistinctSubstring(String str){
        Set<String> set=new HashSet<>();

        for (int i=0;i<str.length();i++){
            String s="";
            for (int j=i;j<str.length();j++){
                s=s+str.charAt(j);
                set.add(s);
            }
        }
        System.out.println(set);
        return set.size();
    }

    //Approach 2: Using Trie Data Structure
    //There can be multiple cases that the string will exist in trie , if yes traverse till last key and make isTerminal false , else create new node
    //Time Complexity O(N^2)
    //Space Complexity: Definitely less
    private static int countDistinctSubstringUsingTrie(String str){
         Node root =new Node();
         int count=0;
        for (int i=0;i<str.length();i++){
            //Start from the root of the trie each time as a starting point
            Node currNode=root;
            for (int j=i;j<str.length();j++){
                char ch=str.charAt(j);
                if (currNode.children[ch-'a']==null)
                {
                    currNode.children[ch-'a']=new Node();
                    currNode.isTerminal=true;
                    count++;
                }
                //move on to the next character
                currNode=currNode.children[ch-'a'];
            }
        }
            return count;
    }

    public static void main(String[] args) {
        //System.out.println(countDistinctSubstring("abba"));
        System.out.println(countDistinctSubstringUsingTrie("abba"));
    }
}
