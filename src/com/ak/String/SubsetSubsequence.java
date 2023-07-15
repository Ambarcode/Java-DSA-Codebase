package com.ak.String;

import java.util.ArrayList;
import java.util.List;

public class SubsetSubsequence {
    private static List<List<Integer>> generateSubsequence(int[] arr){
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());

      for(int elem: arr){
          int n=outer.size();
          for (int i = 0; i < n; i++) {
              ArrayList<Integer> current =new ArrayList<>(outer.get(i));
              current.add(elem);
              outer.add(current);
          }
      }
      return outer;
    }

    //now what happened if we encountered duplicate elements

    public static void main(String[] args) {
        int[] arr={1,2,3};
        List<List<Integer>> ans=generateSubsequence(arr);
        System.out.println(ans);
    }
}
