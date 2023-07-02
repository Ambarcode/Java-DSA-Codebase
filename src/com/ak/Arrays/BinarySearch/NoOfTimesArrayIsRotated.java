package com.ak.Arrays.BinarySearch;

public class NoOfTimesArrayIsRotated {
    //Approach is quite simple , we'll have to find the index of the minimum element in the rotated sorted array
    //using binary search
    private static int countNoOFRotation(int[] arr){
        int start=0;
        int end=arr.length-1;
        while (start <= end) {
            int mid = (start + (end - start) / 2);

            //4 cases;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid+1;
            }

            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid ;
            }

            if (arr[mid] <= arr[start]) {
                end=mid-1;
            } else {
                //minimum elemet is in the second half
                start=mid+1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr={3,4,5,1,2};
        System.out.println(countNoOFRotation(arr));
    }
}
