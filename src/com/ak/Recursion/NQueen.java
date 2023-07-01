package com.ak.Recursion;

public class NQueen {

    public static int queenOnBoard(int row,  boolean[][] board){
        int count=0;
        if(row==board.length){
            return 1;
        }

        for(int col=0;col<board[row].length;col++){
            if(isSafe(row,col,board)){
                    board[row][col]=true;
                    int result=queenOnBoard(row+1,board);
                    count+=result;
                    board[row][col]=false;
            }
        }
        return count;
    }

    private static boolean isSafe(int row, int col, boolean[][] board) {
        //for upward check
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (board[i][j]) {
                return false;
            }
        }
        //for right diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }
        //for left diagonal
        for (int i = row - 1, j = col + 1; i >= 0
                && j < board.length; i--, j++) {
            if (board[i][j]) {
                return false;
            }
        }
        return true;
    }
}
