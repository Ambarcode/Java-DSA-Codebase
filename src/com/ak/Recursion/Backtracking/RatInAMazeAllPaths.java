package com.ak.Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class RatInAMazeAllPaths {
    private static boolean isNotBlocked(int[][] board, int row, int col, int[][] pos) {
        return row >= 0 && row < board.length && col >= 0 && col < board[row].length && board[row][col] == 1 && pos[row][col] != 1;
    }

    public static void ratInAMaze(int[][] board, int row, int col, int[][] pos, List<int[][]> paths, int[][] currentPath) {
        if (row == board.length - 1 && col == board[row].length - 1) {
            pos[row][col] = 1;
            currentPath[row][col] = 1;
            int[][] path = new int[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                System.arraycopy(currentPath[i], 0, path[i], 0, board[i].length);
            }
            paths.add(path);
            pos[row][col] = 0;
            currentPath[row][col] = 0;
            return;
        }

        if (isNotBlocked(board, row, col, pos)) {
            pos[row][col] = 1;
            currentPath[row][col] = 1;

            // Move to the next row
            ratInAMaze(board, row + 1, col, pos, paths, currentPath);

            // Move to the previous row
            ratInAMaze(board, row - 1, col, pos, paths, currentPath);

            // Move to the next column
            ratInAMaze(board, row, col + 1, pos, paths, currentPath);

            // Move to the previous column
            ratInAMaze(board, row, col - 1, pos, paths, currentPath);

            // Undo the changes
            pos[row][col] = 0;
            currentPath[row][col] = 0;
        }
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
        List<int[][]> paths = new ArrayList<>();
        ratInAMaze(board, 0, 0, path, paths, path);

        for (int[][] p : paths) {
            for (int[] row : p) {
                for (int elem : row) {
                    System.out.print(elem + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
