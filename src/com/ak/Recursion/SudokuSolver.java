package com.ak.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuSolver {
    public static void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private static boolean solve(char[][] board, int i, int j) {
        if (i == board.length) {
            return true;
        }
        if (j == board[0].length) {
            return solve(board, i + 1, 0);
        }
        if (board[i][j] != '.') {
            return solve(board, i, j + 1);
        }
        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, i, j, c)) {
                board[i][j] = c;
                if (solve(board, i, j + 1)) {
                    return true;
                }
                board[i][j] = '.';
            }
        }
        return false;
    }

    private static boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == ch || board[row][i] == ch) {
                return false;
            }
        }

        int boxStartRow = 3 * (row / 3);
        int boxStartCol = 3 * (col / 3);

        for (int r = boxStartRow; r < boxStartRow + 3; r++) {
            for (int c = boxStartCol; c < boxStartCol + 3; c++) {
                if (board[r][c] == ch) {
                    return false;
                }
            }
        }

        return true;
    }
    private static boolean isPlaceable(char[][] board, int row, int col, char ch) {
        //check for the same row
        for (char[] chars : board) {
            if (chars[col] == ch) return false;
        }

        //check for the col
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == ch) return false;
        }

        //Now check for the 3*3 grid

        //first I need to find the starting rowIndex for that particular grid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == ch) return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
        List<List<Character>> list = new ArrayList<>();
        for (char[] row : board) {
            List<Character> rowList = new ArrayList<>();
            for (char c : row) {
                rowList.add(c);
            }
            list.add(rowList);
        }
        for (List<Character> row : list) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
