package com.ak.Arrays.ArrayQuestion;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        //here we'll use xor operation
        //the approach is simple
        // a XOR a =0
        // a XOR 0= a
        //So we'll XOR the whole array and at last the element , which is present at only once will remain in the array

        int xor=0;
        for (int num : nums) {
            xor = xor ^ num;
        }
        return xor;
    }
}
