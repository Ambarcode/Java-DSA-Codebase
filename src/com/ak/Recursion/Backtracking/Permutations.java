package com.ak.Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer=new ArrayList<>();
        permuteHelper(new ArrayList<>(),nums,answer);
        return answer;
    }

    private static void permuteHelper(List<Integer> current , int[] nums , List<List<Integer>> ans){
        if(current.size()==nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (current.contains(num)) {
                continue;
            }
            current.add(num);
            permuteHelper(current, nums, ans);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<List<Integer>> ans=permute(nums);
        System.out.println(ans);

        }
    }

