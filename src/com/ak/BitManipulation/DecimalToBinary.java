package com.ak.BitManipulation;

public class DecimalToBinary {
    public static void main(String[] args) {
      int num=23;
      int numCopy=num;
      String str="";
      while (num>0){
         int lastS= num&1;
         str=lastS+str;
         num>>=1;
      }
        System.out.println(Integer.toBinaryString(numCopy));
        System.out.println(str);
    }
}
