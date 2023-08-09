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


    //Another Approach , when we are returning only a number
    private int decToBinary(int num) {
        int ans = 0;
        int base = 1;

        while (num > 0) {
            int rem = num % 2;
            num /= 2;
            ans += rem * base;
            base *= 10;
        }

        return ans;
    }
}
