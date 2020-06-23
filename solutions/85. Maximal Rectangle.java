class Solution 
{
    public int maximalRectangle(char[][] matrix) 
    {
        if(matrix == null || matrix.length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] height = new int[m + 1];
        int max = 0;
        for(int i=0;i<matrix.length;i++)
        {
            updateHeights(matrix, i, height);
            max = Math.max(max, maxArea(height));
        }
        return max;
    }
    private void updateHeights(char[][] matrix, int row, int[] heights) 
    {
        for (int col = 0; col < matrix[0].length; col++) 
        {
            if (matrix[row][col] == '1') 
                heights[col]++;
            else 
                heights[col] = 0;
        }
    }

    private int maxArea(int[] heights)
    {
        int n = heights.length;
        int[] stack = new int[n + 1];
        int l = 0;
        stack[l] = -1;
        int res = 0;
        for (int r = 0; r < n; r++) 
        {
            while (l > 0 && heights[r] < heights[stack[l]]) 
            {
                int h = heights[stack[l--]];
                res = Math.max(res, h * (r - stack[l] - 1));
            }
            stack[++l] = r;
        }
        return res;
    }
}