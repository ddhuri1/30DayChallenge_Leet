/*class Solution 
{
    public int minPathSum(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;
        int[][] path = new int[grid.length][grid[0].length];
        path[0][0] = grid[0][0];
        for(int i = 1; i < grid.length; i++)
        {
            path[i][0] = path[i-1][0] + grid[i][0];
        }
        for(int i = 1; i < grid[0].length; i++)
        {
            path[0][i] = path[0][i-1] + grid[0][i];
        }
        for(int i = 1; i < grid.length; i++)
        {
            for(int j = 1; j< grid[0].length; j++)
            {
                path[i][j] = Math.min(grid[i][j] + path[i-1][j] , grid[i][j] + path[i][j-1] );
            }
        }
        return path[m-1][n-1];
    }
}*/

class Solution {
    public int minPathSum(int[][] grid) {
        int[][] cost = new int[grid.length][grid[0].length];        
        return minPath(grid, 0, 0, cost);
    }
    
    public int minPath(int[][] grid, int i, int j, int[][] cost) {
		// if we went out of boundaries.
        if (i > grid.length-1 || j > grid[0].length-1) {
            return Integer.MAX_VALUE;
        }
		// check if visited
        if (cost[i][j] > 0) {
            return cost[i][j];        
        }
		// we've reached the destination
        if (i == grid.length-1 && j == grid[0].length-1) {
            return grid[i][j];
        }
        int bottom = minPath(grid, i+1, j, cost);
        int right = minPath(grid, i, j+1, cost);
        cost[i][j] = Math.min(bottom, right) + grid[i][j];
        return cost[i][j];
    }
}