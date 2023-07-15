package com.ak.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class MergeOverlappingInterval {

    public int[][] merge(int[][] intervals) {
        Pair[] pair = new Pair[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            pair[i] = new Pair(intervals[i][0], intervals[i][1]);
        }

        Arrays.sort(pair);
        Stack<Pair> st = new Stack<>();
        st.push(pair[0]);
        for (int i = 1; i < intervals.length; i++) {
            Pair p = st.peek();
            if (pair[i].st > p.et) {
                st.push(pair[i]);
            } else {
                p.et = Math.max(pair[i].et, p.et);
            }
        }

        int[][] mergedIntervals = new int[st.size()][2];
        int i = st.size() - 1;
        while (!st.isEmpty()) {
            Pair p1 = st.pop();
            mergedIntervals[i][0] = p1.st;
            mergedIntervals[i][1] = p1.et;
            i--;
        }

        return mergedIntervals;
    }

    private static class Pair implements Comparable<Pair>{
        int st;
        int et;

        Pair(int st , int et){
            this.st=st;
            this.et=et;
        }

        //this>other return positive
        //this<other return negative
        //this ==other return 0
        @Override
        public int compareTo(Pair other) {
            if (this.st!=other.st) {
                return this.st-other.st;
            }
            else return this.et-other.et;
        }
    }
}


