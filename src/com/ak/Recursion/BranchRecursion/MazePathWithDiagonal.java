package com.ak.Recursion.BranchRecursion;

public class MazePathWithDiagonal {
    static void mazePAthProblem(int row , int col , int endRow , int endCol , String result){
        if(row==endRow && col==endCol) System.out.println(result);

        if (row<endRow){
            mazePAthProblem(row+1,col,endRow,endCol,result+"D");
        }
        if (col<endCol){
            mazePAthProblem(row,col+1,endRow,endCol,result+"R");
        }
        if (row<endRow && col<endCol){
            mazePAthProblem(row+1,col+1,endRow,endCol,result+"Di");
        }
    }

    public static void main(String[] args) {
        mazePAthProblem(0,0,2,2,"");
    }
}
