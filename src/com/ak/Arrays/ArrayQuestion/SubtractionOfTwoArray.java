package com.ak.Arrays.ArrayQuestion;

import java.util.ArrayList;
import java.util.Arrays;

public class SubtractionOfTwoArray {
    public static void main(String[] args) {

        //we'll take an assumption that arr2 is always greater than arr1
        int[] nums1={9,9,9};
        int[] nums2={1,0,0,0};
        int[] ans=findDiff(nums1,nums2);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] findDiff(int[] nums1 , int[] nums2){
        int[] diff=new int[nums2.length];
        int i=nums1.length-1;
        int j=nums2.length-1;
        int k=diff.length-1;

        int carry=0;
        while (k>=0){
            int d=0;
            int a1Val=i>=0?nums1[i]:0;
            if (nums2[j]+carry>=a1Val){
                d=nums2[j]+carry-a1Val;
                carry=0;
            }
            else {
                d=nums2[j]+carry+10-a1Val;
                carry=-1;
            }

            diff[k]=d;
            i--;
            j--;
            k--;
        }

        int indx=0;
        while (indx<diff.length){
            if (diff[indx]==0) {
                indx++;
            } else break;
        }

        return Arrays.copyOfRange(diff,indx,diff.length);


    }


}
