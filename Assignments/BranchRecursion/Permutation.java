package com.ak.Recursion.BranchRecursion;

public class Permutation {
    static void perm(String str , String res){
        if(res.isEmpty()){
            System.out.println(str);
            return;
        }

        char ch=res.charAt(0);
        for (int i = 0; i <=str.length() ; i++) {

            String first=str.substring(0,i);
            String second=str.substring(i,str.length());
            perm(first+ch+second,res.substring(1));
        }
    }

    public static void main(String[] args) {
        perm("","Ambar");
    }
}
