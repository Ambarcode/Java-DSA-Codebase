package com.ak.Arrays.ArrayQuestion;

import java.util.ArrayList;
import java.util.List;

public class AdditionOfTwoArray {

    public static void main(String[] args) {
        int[] nums1={1,2,3,5};
        int[] nums2={2,3,4,5};
        ArrayList<Integer> ans=findSum(nums1,nums2);
        System.out.println(ans);
    }

    private static ArrayList<Integer> findSum(int[] nums1 , int[] nums2){
        ArrayList<Integer> list =new ArrayList<>();
        int carry=0;
        int i=0; //pointer pointing to the first element of the array
        int j=0; //pointer pointing to the first element of the second array
        while (i<nums1.length || j<nums2.length){
            int p=i<nums1.length?nums1[i]:0;
            int q=j<nums2.length?nums2[i]:0;
                 int sum=0;
                 sum=sum+p+q+carry;
                 carry=sum/10;
                 list.add(sum%10);
                 if(i<nums1.length)i++;
                 if(j<nums2.length) j++;
        }

        if(carry>0){
            list.add(carry);
        }

        return list;
    }
}
