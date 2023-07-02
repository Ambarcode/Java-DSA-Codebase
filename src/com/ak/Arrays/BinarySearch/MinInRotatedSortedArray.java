package com.ak.Arrays.BinarySearch;

public class MinInRotatedSortedArray {
      private static int minInSortedArray(int[] arr){
          int start=0;
          int end=arr.length-1;
          while (start <= end) {
              int mid = (start + (end - start) / 2);

              //4 cases;
              if (mid < end && arr[mid] > arr[mid + 1]) {
                  return arr[mid+1];
              }

              if (mid > start && arr[mid] < arr[mid - 1]) {
                  return arr[mid] ;
              }

              if (arr[mid] <= arr[start]) {
                  end=mid-1;
              } else {
                  //minimum element is in the second half
                  start=mid+1;
              }
          }
          return arr[0];
      }

    public static void main(String[] args) {
      int[] arr={5,6,7,0,1,2};
        System.out.println(minInSortedArray(arr));
    }
}
