package com.ak.Recursion.DsaTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution2 {
    public ArrayList<Integer> perfect(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (isPerfect(i, i - 1, 0)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isPerfect(int number, int divisor, int sum) {
        if (divisor == 0) {
            return sum == number;
        }
        if (number % divisor == 0) {
            sum += divisor;
        }
        return isPerfect(number, divisor - 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // Reading N
        String str = bufferedReader.readLine().trim();
        int n = Integer.parseInt(str);
        Solution2 solution = new Solution2();
        ArrayList<Integer> result = solution.perfect(n);
        System.out.println(result);
}
}
