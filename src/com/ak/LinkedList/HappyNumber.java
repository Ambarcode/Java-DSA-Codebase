package com.ak.LinkedList;

class HappyNumber {
    public boolean isHappy(int n) {
        //It can be implemented by two approaches
        //1. Create a hashset , for each n calculate sum and check whether the set contains that number or not , if the set contains that number , it means the process it repeating which means there is a cycle

        //2. We can also see this question as detection of cycle in linkedlist question i.e if the sum(pairs) occurs again there is a cycle in linkedlist

        // Initialize slow and fast pointers
        int slow = n;
        int fast = n;

        // Loop until slow and fast pointers meet
        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);

        //cycle detected
        // Check if slow reached 1, indicating a happy number(i.e if the cycle is  due to both reach 1)
        return slow == 1;
    }

    // Helper function to calculate the sum of squares of digits
    public int findSquare(int num) {
        int sum = 0;
        while (num > 0) {
            int rem = num % 10;
            sum += rem * rem;
            num /= 10;
        }
        return sum;
    }
}
