package com.ak.HashMapAndHeap;

import java.util.*;

import java.util.LinkedList;
class Main
{
    static int function(int n)
    {
        if (n % 4 == 0)
            return n;
        if (n % 4 == 1)
            return 1;
        if (n % 4 == 2)
            return n + 1;
        else
            return 0;
    }

    public static void main(String[] args)
    {
       int x=4;
        x = x & (x-1) ;
        System.out.println(function(12));
    }
}
 class Solution {
    public static void main(String[] args) {
        int[] a = {0,2,4,1,3};
        for(int i = 0; i < a.length; i++){
            a[i] = a[(a[i] + 3) % a.length];
        }
        System.out.println(a[1]);

    }
}