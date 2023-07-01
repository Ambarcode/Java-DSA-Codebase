package com.ak.Arrays.ArrayQuestion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class TwoSum {

    //first Approach : Using Sorting and taking two pointers
    public static int[] twoSum(int[] nums, int target) {
     Pair[] pairs=new Pair[nums.length];

        for (int i = 0; i < nums.length; i++) {
            pairs[i]=new Pair(nums[i],i);
        }

        //sorting the pair array based on number
        Arrays.sort(pairs, Comparator.comparingInt(eachPair-> eachPair.index));

        int start=0;
        int end=nums.length-1;
        for (int i = 0; i <nums.length ; i++) {
            int sum=pairs[start].number+pairs[end].number;
            if (sum==target) return new int[]{pairs[start].index,pairs[end].index};
            else if (sum<target) start++;
            else end--;
        }
        return new int[]{-1,-1};
    }

    //second Approach using Hashing
  public static int[] twoSum2(int[] nums , int k){
      HashMap<Integer,Integer> map=new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
          map.put(nums[i],i);
      }
      for (int i = 0; i < nums.length; i++) {
          int rem=k-nums[i];
          if (map.containsKey(rem)){
              int index=map.get(rem);
              if (index==i) continue;
              return new int[]{i,index};
          }
      }
      return new int[]{-1,-1};
  }


    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums,13)));
    }
}

class Pair{
    int number;
    int index;

    public Pair(int number,int index){
        this.number=number;
        this.index=index;
    }
}
