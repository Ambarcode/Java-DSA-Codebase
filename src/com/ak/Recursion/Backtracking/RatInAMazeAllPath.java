package com.ak.Recursion.Backtracking;

public class RatInAMazeAllPath {
    private static boolean isNotBlocked(int[][] board, int row, int col, int[][] pos) {
        return row >= 0 && row < board.length && col >= 0 && col < board[row].length && board[row][col] == 1 && pos[row][col] != 1;
    }

    public static boolean ratInAMaze(int[][] board, int row, int col, int[][] pos) {
        if (row == board.length - 1 && col == board[row].length - 1) {
            pos[row][col] = 1;
            return true;
        }

        if (isNotBlocked(board, row, col, pos)) {
            pos[row][col] = 1;

            // Move to the next row
            if (ratInAMaze(board, row + 1, col, pos))
                return true;

            // Move to the previous row
            if (ratInAMaze(board, row - 1, col, pos))
                return true;

            // Move to the next column
            if (ratInAMaze(board, row, col + 1, pos))
                return true;

            // Move to the previous column
            if (ratInAMaze(board, row, col - 1, pos))
                return true;

            // Undo the changes
            pos[row][col] = 0;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] board = {
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {1, 0, 1, 1, 1}
        };

        int[][] path = new int[board.length][board[0].length];
        boolean result = ratInAMaze(board, 0, 0, path);
        if (result) {
            for (int[] arr : path) {
                for (int elem : arr) {
                    System.out.print(elem + " ");
                }
                System.out.println();
            }
        }
    }
}
