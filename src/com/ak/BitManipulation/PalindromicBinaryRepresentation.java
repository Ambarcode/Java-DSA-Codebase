package com.ak.BitManipulation;

public class PalindromicBinaryRepresentation {

        public static int solve(int A) {
                int count = 0;
                int num = 0;
                int i = 1;

                while (count < A) {
                        if (isPalindromic(Integer.toBinaryString(i))) {
                                count++;
                                num = i;
                        }
                        i++;
                }
                return num;

        }
        public boolean isPalindrome(int number) {
                int reversed = 0;
                int temp = number;

                while (temp > 0) {
                        reversed = (reversed << 1) | (temp & 1);
                        temp >>= 1;
                }

                return number == reversed;
        }

        private static boolean isPalindromic(String toBinaryString) {
                StringBuilder sb=new StringBuilder(toBinaryString);
                sb.reverse();
                return sb.toString().equals(toBinaryString);
        }

        //Now let's see a optimized approach


        public static void main(String[] args) {
                System.out.println(solve(2000));
        }

}
