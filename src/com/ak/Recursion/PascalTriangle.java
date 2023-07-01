package com.ak.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> ans=new ArrayList<>();
        for (int i = 0; i <numRows ; i++) {
            List<Integer> col=new ArrayList<>();
            for (int j = 0; j <=i; j++) {
                if (j==0|| j==i){
                    col.add(1);
                }
                else {
                    col.add(j,ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
                }

            }
            ans.add(col);
        }
        return ans;
    }
}
