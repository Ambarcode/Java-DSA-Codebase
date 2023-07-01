package com.ak.Recursion.Backtracking;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (dfs(board, row, col, word, 0))
                    return true;
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, int row, int col, String word, int index) {
        if (index == word.length())
            return true;

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index))
            return false;

        char originalChar = board[row][col];
        board[row][col] = '#';

        boolean found = dfs(board, row + 1, col, word, index + 1) ||
                dfs(board, row - 1, col, word, index + 1) ||
                dfs(board, row, col + 1, word, index + 1) ||
                dfs(board, row, col - 1, word, index + 1);

        board[row][col] = originalChar;

        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCED";
        System.out.println(exist(board,word));
    }
}
