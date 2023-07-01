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

        //Now let's see an optimized approach
        private static int findNthPalindromicBinary(int n) {
                int count = 1;
                int len = 1;

                while (count < n) {
                        len++;
                        int elemAtThisPos = (1 << ((len - 1) / 2));
                        count += elemAtThisPos;
                }
                count-=(1 << ((len - 1) / 2));
                int offset=n-count-1;
                int ans=1<<len-1;
                ans|=(offset<<len-2);

                int valPR = (ans >> (len / 2));
                int rev = reverse(valPR);

                ans |= rev;
                return ans;
        }
        public static int reverse(int number) {
                int reversed = 0;
                int temp = number;

                while (temp > 0) {
                        reversed = (reversed << 1) | (temp & 1);
                        temp >>= 1;
                }
                return reversed;
        }

        public static void main(String[] args) {
                System.out.println(Integer.toBinaryString(findNthPalindromicBinary(2000)));
        }

}
