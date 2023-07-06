package com.ak.Arrays.ArrayQuestion;

public class FindMedianOFTwoSortedArray {
    //we'll use the approach of merge two sorted list concept
     private static int[] merge(int[] a , int[] b){
         int[] ans=new int[a.length+b.length];
         int i=0,j=0,k=0;
         while (i<a.length && j< b.length){
             if(a[i]<b[j]){
                 ans[k]=a[i];
                 i++;
             }
             else{
                 ans[k]=b[j];
                 j++;
             }
             k++;
         }
         //now there is a possibility that there are some A elements left
         while (i<a.length){
             ans[k++]=a[i];
             i++;
         }
         //now there is a possibility that there are some B elements left
         while (j<b.length){
             ans[k++]=b[j];
             j++;
         }

         return ans;
     }

    public static double findMedianSortedArrays(int[] a, int[] b) {
         int[] ans=merge(a,b);
         int n=ans.length;
         if(n%2==0) return (double)(ans[n/2 - 1]+ans[n/2])/2;
         else return (double)(ans[n/2]);
     }

    public static void main(String[] args) {

    }

}
