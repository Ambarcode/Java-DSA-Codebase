package com.ak.Recursion.BranchRecursion;

public class MazePath {
    static void mazePAthProblem(int row , int col , int endRow , int endCol , String result){
        if(row==endRow && col==endCol) System.out.println(result);

        if (row<endRow){
            mazePAthProblem(row+1,col,endRow,endCol,result+"D");
        }
        if (col<endCol){
            mazePAthProblem(row,col+1,endRow,endCol,result+"R");
        }
    }

    public static void main(String[] args) {
        mazePAthProblem(0,0,3,3,"");
    }
}
