package com.ak.Recursion.DsaTest;

import java.io.*;


    class Solution {
        public String convert(int n) {
            if (n == 0) {
                return "";  // Base case: return empty string for a decimal number 0
            } else {
                int remainder = n % 16;
                int quotient = n / 16;
                String hexDigit = getHexDigit(remainder);
                return convert(quotient) + hexDigit;  // Recursively convert quotient and append hex digit
            }
        }

        public int octalToDecimal(int n, int power) {
            if (n == 0) {
                return 0;  // Base case: return 0 for an octal number with no digits
            } else {
                int lastDigit = n % 10;
                int remainingDigits = n / 10;
                return lastDigit * (int) Math.pow(8, power) + octalToDecimal(remainingDigits, power + 1);  // Recursively convert remaining digits
            }
        }

        private String getHexDigit(int digit) {
            if (digit < 10) {
                return String.valueOf(digit);  // Convert digit to its string representation
            } else {
                // Convert digit to its hexadecimal representation (A-F)
                char[] hexDigits = {'A', 'B', 'C', 'D', 'E', 'F'};
                return String.valueOf(hexDigits[digit - 10]);
            }
        }
    }

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            // Reading N
            String str = bufferedReader.readLine().trim();
            int n = Integer.parseInt(str);

            Solution solution = new Solution();
            int decimalNum = solution.octalToDecimal(n, 0);
            String result = solution.convert(decimalNum);
            System.out.println(result);
        }
    }

