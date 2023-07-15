package com.ak.Arrays.ArrayQuestion;

public class SingleNumberii{
    //we can easily solve the question using bit manipulation
    //we'll count total set bits at each position and the bit's which are of the form 3n+1 are ON and the one form 3n will be off

    private static int solve(int[] nums){
        int _3n=-1; //initially all the bits will be 000000, so it is of the form 3n
        int _3nPlus1=0; //this part will contain our answer
        int _3nPlus2=0;


        for (int i=0;i<nums.length;i++){
            int countSet1=_3n&nums[i];
            int countSet2=_3nPlus1&nums[i];
            int countSet3=_3nPlus2&nums[i];

            //we have to off the bits in _3n for which it's Anding is 1 as they are repeating and should be moved to 3n+1
            _3n=_3n&(~countSet1);

            //set the bits of 3n+1 which is extra in 3n
            _3nPlus1=_3nPlus1|countSet1;

            //we have to off the bits of 3n+1 which is repeating in it and pass it to 3n+2
            _3nPlus1=_3nPlus1&(~countSet2);

            // set the bits of 3n+1 which is extra in 3n+1
            _3nPlus2=_3nPlus2|countSet2;

            //off the bits in 3n+2 which is repeating and set it in 3n as 3n+3 is of type 3
            _3nPlus2=_3nPlus2&(~countSet3);

            //set in 3n
            _3n=_3n| countSet3;
        }

        //at last 3n+1 will contain our answer
        return _3nPlus1;
    }

    public static void main(String[] args) {
        int[] nums={2,2,3,2};
        System.out.println(solve(nums));
    }
}
