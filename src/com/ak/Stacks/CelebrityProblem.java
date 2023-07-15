package com.ak.Stacks;

import java.util.Stack;

public class CelebrityProblem {
    //A celebrity is anyone which is known by everyone , but he knows none
    //There cannot be two celebrity , but there can be possibility there is no celebrity
    //we'll follow the elimination approach
    //challenge: solve it in O(N) time

    public static int findCelebrity(int[][] m){

        //first we look for the potential candidate
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<m.length;i++){
            st.push(i);
        }

        //now pop two element from the stack and check whether they know anyone
        while (st.size()>=2){
            int i=st.pop();
            int j=st.pop();

            if (m[i][j]==1){
                //if i knows j then i is not a celebrity
                st.push(j);
            }
            else {
                st.push(i);
            }
        }

        //now we have found a potential candidate
         int pot=st.pop();
         for (int i=0;i<m.length;i++){
             if (i!=pot){
                 if (m[pot][i]==1 ||m[i][pot]==0){ //condition violation
                     return -1;
                 }
             }
         }
         return pot;
    }

    public static void main(String[] args) {
        int[][] matrix={ {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 1, 0, 0}, {0, 0, 1, 0} };
        if (findCelebrity(matrix)==-1) {
            System.out.println("No celebrity");
        }else System.out.println(findCelebrity(matrix));
    }

}
