package com.ak.Graph;

public class NoOFIslands {
    //it's basically a question of implicit graph
    //we are given a 2D matrix , we have to count the number of connected components
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    traverse(grid, i, j, vis);
                    count++;
                }
            }
        }
        return count;
    }

    private void traverse(char[][] grid, int i, int j, boolean[][] vis) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || vis[i][j] || grid[i][j] == '0') {
            return;
        }

        vis[i][j] = true;
        // Visiting all the four connected components
        traverse(grid, i - 1, j, vis);
        traverse(grid, i, j - 1, vis);
        traverse(grid, i + 1, j, vis);
        traverse(grid, i, j + 1, vis);
    }

}
