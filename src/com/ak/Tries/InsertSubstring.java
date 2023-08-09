package com.ak.Tries;

public class InsertSubstring {
    public static void main(String[] args) {
        String str="Ambar";
        Tries.TrieNode root=new Tries.TrieNode();
        for (int i = 0; i <str.length() ; i++) {
            String s=str.substring(i);
            Tries.insert(s,root);
        }

        System.out.println(Tries.search("mbar",root));
    }
}
