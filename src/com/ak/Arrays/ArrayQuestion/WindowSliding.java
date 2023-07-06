package com.ak.Arrays.ArrayQuestion;

public class WindowSliding {
//sliding window technique is a technique in which a window is slide over elements , when we swipe the window , first element got excluded and next element got include the next
//questions on sliding window: Subset Problem Mostly


private static void kWindowSum(int[] arr, int k){
    //arr={1,2,3,4,5,6,7,8,9,10};
    int sum=0;
    //add first k elements
    for (int i = 0; i < k; i++) {
        sum+=arr[i];
    }
    System.out.println(sum);

    //exclude the first and add the last
    for (int i = k; i <= arr.length-1 ; i++) {
        sum=sum-arr[i-k]+arr[i];
        System.out.println(sum);
    }
}

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        kWindowSum(arr,3);
    }
}
