package com.ak.Arrays.ArrayQuestion;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInAnArray {
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        //I will use the approach of next greater element
        //Stack<Integer> st=new Stack<>();
        ArrayList<Integer> list=new ArrayList<>();
        list.add(arr[arr.length-1]);

        int i=arr.length-2;
        while(i>=0){
            if(arr[i]<list.get(list.size()-1)){ i--; continue;}
            else list.add(arr[i]);
            i--;
        }

        Collections.reverse(list);
        return list;
    }
}
