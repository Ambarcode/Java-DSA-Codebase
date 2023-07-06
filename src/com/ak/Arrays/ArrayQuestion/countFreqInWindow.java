package com.ak.Arrays.ArrayQuestion;

public class countFreqInWindow {
    //you are given an array , we have to count the frequency of an element in the given k window
     private static void countFreqInKSizeWindow(int[] arr, int elem, int k){
         //arr={1,2,1,3,3,2,2,4,5,3};
         int freq=0;
         for(int i=0;i<k;i++){
             if(arr[i]==elem) {
                 freq++;
             }
         }
         System.out.println("Frequency in 1 Window: " + freq);
         for (int i = 1; i <= arr.length-k ; i++) {
             int prevElem=arr[i-1];
             if (prevElem==elem) freq--;
             int nextElemToBeAdded=arr[i+k-1];
             if (nextElemToBeAdded==elem) freq++;
             System.out.println("Frequency in " +(i+1)+ " Window: "+freq);
         }
     }

    public static void main(String[] args) {
        countFreqInKSizeWindow(new int[]{1,2,2,3,2,1,4,2,1,5,6,7,2},2,3);
    }
}

